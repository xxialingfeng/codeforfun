package cs61b;

public class DataIndexedCharMap<V> {
    private V[] items;
    public DataIndexedCharMap(int R){
        items = (V[]) new Object[R]; // R is the possible
        //characters, e.g. 128 for ASCII
    }
    public void put(char c, V val){
        items[c] = val;
    }
    public V get(char c){
        return items[c];
    }
}
