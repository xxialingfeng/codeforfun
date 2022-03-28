package synthesizer;
import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T>{
    int capacity();
    int fillCount();
    void enqueue(T x);
    T dequeue();
    T peek();
    default boolean isEmpty(){
        if(this.fillCount() == 0){
            return true;
        }
        return false;
    }
    default boolean isFull(){
        if(this.fillCount() == this.capacity()){
            return true;
        }
        return false;
    }
    Iterator<T> iterator();
}
