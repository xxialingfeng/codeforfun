package cs61b;

public class AList<Item>  implements List61B<Item> {
    private Item[] items;
    private int size;

    public AList(){
        items = (Item[]) new Object[100];
        size = 0;
    }
    public AList(Item x){
        items = (Item[]) new Object[100];
        size = 0;
    }

    @Override
    public void addFirst(Item x) {
        insert(x, 0);
    }

    @Override
    public Item getFirst() {
        return get(0);
    }

    @Override
    public void insert(Item x, int position) {
       Item[] newItems = (Item[]) new Object[items.length+1];
       System.arraycopy(items, 0, newItems, 0, position);
       newItems[position] = x;
       System.arraycopy(items, position, newItems, position+1, items.length - position);
       items = newItems;
    }

    public void resize(int capacity){
            Item[] a = (Item[]) new Object[capacity];
            System.arraycopy(items,0,a,0,size);
            items = a;
            size += 1;
    }
    public Item deleteBack(){
        Item returnItem = getLast();
        items[size-1] = null;
        size -= 1;
        return returnItem;
    }

    public void addLast(Item x){
        if(size == items.length){
            resize(size+1);
        }
        items[size] = x;
        size += 1;
    }

    public Item getLast(){
        return items[size-1];
    }

    public Item get(int i ){
        return items[i];
    }

    public int size(){
        return size;
    }

    public Item removeLast(){
        Item x = getLast();
        size = size-1;
        return x;
    }
}
