package cs61b;

public class ArrayListDeque<T> implements Deque<T> {
    private T[] Item;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayListDeque() {
        Item = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void upSize() {
        resize(size * 2);
    }

    private void downSize() {
        resize(size / 2);
    }

    private int plusOne(int index) {
        return (index + 1) % Item.length;
    }

    private int minusOne(int index) {
        return (index - 1 + Item.length) % Item.length;
    }

    private boolean isFull() {
        return size == Item.length;
    }

    private boolean isSparse() {
        return Item.length >= 16 && size < (Item.length / 4);
    }

    private void resize(int capacity , ArrayListDeque<T> src) {
        T[] target = (T[]) new Object[capacity];
        int oldIndex = plusOne(src.nextFirst);

        for (int i = 0; i < src.size; i++) {
            target[i] = src.Item[oldIndex];
            oldIndex = plusOne(oldIndex);
        }

        Item = target;
        nextFirst = capacity - 1;
        nextLast = src.size;
        size = src.size;
    }

    private void resize(int capacity) {
        resize(capacity,this);
    }

    @Override
    public void addFirst(T item) {
        if (isFull()) upSize();
        Item[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;

    }

    public void addLast(T item) {
        if (isFull()) upSize();
        Item[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;

    }

    public void printDeque() {

        int itemIndex = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(Item[itemIndex] + "     ");
            itemIndex = plusOne(itemIndex);
        }
        System.out.println();

    }

    public T removeFirst() {
        nextFirst = plusOne(nextFirst);

        T returnItem = Item[nextFirst];
        Item[nextFirst] = null;
        size--;
        if (isSparse()) downSize();
        return returnItem;
    }

    public T removeLast() {
        nextLast = minusOne(nextLast);
        T returnItem = Item[nextLast];

        Item[nextLast] = null;
        size--;

        if (isSparse()) downSize();

        return returnItem;

    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int start = plusOne(nextFirst);
        return Item[(start + index) % Item.length];

    }

    public static void main(String[] args) {

        ArrayListDeque<Integer> L = new ArrayListDeque<>();
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(15);
        L.addLast(20);
        L.addLast(30);
        L.addLast(40);
        L.addLast(50);
        L.addLast(60);
        L.addLast(70);
        L.addLast(80);

        ArrayListDeque<Integer> L1 = new ArrayListDeque<>();

        System.out.println(L1.isEmpty());

        L.printDeque();
        L1.printDeque();
        System.out.println(L1.removeFirst());
        L.printDeque();
        L1.printDeque();
        System.out.println(L1.removeLast());
        L.printDeque();
        L1.printDeque();
        System.out.println(L1.get(1));
    }
}
