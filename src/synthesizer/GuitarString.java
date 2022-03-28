package synthesizer;

public class GuitarString<T>{
    private static final int SR = 44100;
    private static final double DECAY = 0.996;

    private BoundedQueue<Double> buffer;

    public GuitarString(double frequency){
        buffer =  new ArrayRingBuffer<Double>((int) Math.round(SR / frequency));
        for(int i = 0; i < buffer.capacity(); i++){
            buffer.enqueue(0.0);
        }
    }

    public void pluck(){
        for(int i = 0; i < buffer.capacity(); i++){
            buffer.dequeue();
            double r = Math.random() - 0.5;
            buffer.enqueue(r);
        }
    }

    public void merge(){
        while(true) {
            double temp = buffer.dequeue();
            double next = buffer.peek();
            double newDouble = (temp + next) * DECAY * 0.5;
            buffer.enqueue(newDouble);
        }
    }
}
