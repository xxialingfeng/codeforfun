package cs61b;

public class LinkedListDeque<T> implements List61B<T>{
    /**created the double linked list */
    private class Node {
        private T item;
        private Node prev;
        private Node next;
        public Node(T i, Node pre, Node nex) {
            item = i;
            prev = pre;
            next = nex;
        }
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void insert(T x, int position) {

    }

    private Node sentinel;
    private int count;
    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        count = 0;
    }
    public void addFirst(T item){
        Node first = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = first;
        if (count == 0) {
            sentinel.next = new Node(item, sentinel, sentinel.next);
            sentinel.prev = sentinel.next;
        } else {
            sentinel.next = new Node(item, sentinel, sentinel.next);
        }
        count = count + 1;
    }

    public void addLast(T item) {
        Node last = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        if (count == 0) {
            sentinel.prev = last;
            sentinel.next = sentinel.prev;
        } else {
            sentinel.prev = last;
        }
        count += 1;
    }

    public boolean isEmpty(){
        return (count == 0);
    }

    public int size(){
        return count;
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        else{
            T first = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            count -= 1;
            return first;
        }
    }

    public T removeLast(){
        T last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        count -= 1;
        return last;
    }

    public T get(int index){
        if(index > size()-1){
            return null;
        }
        else{
            int i = 0;
            while(i < index){
                sentinel.next = sentinel.next.next;
                i = i + 1;
            }
        }
        return sentinel.next.item;
    }

    public T getRecursive(int index) {
        if (index > size() - 1) {
            return null;
        }
        if (index == 0) {
            return sentinel.next.item;
        } else {
            sentinel.next = sentinel.next.next;
            return getRecursive(index - 1);
        }
    }
    public LinkedListDeque(LinkedListDeque other){
        sentinel = new Node(null,null,null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
        count = 0;
        int i = 0;
        for(i = 0; i < other.size(); i ++){
            addLast((T)other.get(i));
        }
    }

    @Override
    public void print(){
        for(Node p = sentinel.next; p!= null; p = p.next){
            System.out.print(p.item + " ");
        }
    }

}
