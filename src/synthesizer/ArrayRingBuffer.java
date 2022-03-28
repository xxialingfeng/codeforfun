package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> implements BoundedQueue<T> {

    private int first;
    private int last;

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T>{
        private int currPos;
        private int count;

        public ArrayRingBufferIterator(){
            currPos = first;
            count = 0;
        }

        @Override
        public boolean hasNext(){
            return count < fillCount();
        }

        @Override
        public T next() {
            T currItem = rb[currPos];
            currPos = (currPos + 1) % capacity();
            count += 1;
            return currItem;
        }
    }


    private int fillCount;
    private T[] rb;
    public ArrayRingBuffer(int capacity){
        first = 0;
        last = 0;
        rb = (T[]) new Object[capacity]; //创建一个初始的对象，用Object
        fillCount = 0;
    }
    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    @Override
    public void enqueue(T x) {
        if(isFull()){
            throw new RuntimeException("Ring buffer overflow");
        }else{
            rb[last] = x;
            last = (last+1) % capacity();
            fillCount += 1;
        }
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        T dequeueItem = rb[first];
        first = (first + 1) % capacity();
        fillCount -= 1;
        return dequeueItem;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    @Override
    public boolean equals(Object other) {
        // Compare to itself.
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArrayRingBuffer<T> o = (ArrayRingBuffer<T>) other;
        if (o.fillCount() != this.fillCount()) {
            return false;
        }
        Iterator<T> thisIterator = this.iterator();
        Iterator<T> otherIterator = o.iterator();
        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            if (thisIterator.next() != otherIterator.next()) {
                return false;
            }
        }
        return true;
    }


}
