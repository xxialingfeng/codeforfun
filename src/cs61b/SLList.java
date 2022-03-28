package cs61b;

public class SLList{
    private IntNode first;
    private int size_count;
    private IntNode sentinel;
    public class IntNode{
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }
    public SLList(int x){
        sentinel =  new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size_count = 1;
    }
    /* constructor */
    public SLList(){
        sentinel =  new IntNode(63, null);
        size_count = 0;
    }

    public void addFirst(int x){
        first = new IntNode(x, first);
        size_count += 1;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    public int getFirst(){
        return sentinel.next.item;
    }


    public void addLast(int x){
        size_count += 1;
        IntNode p = sentinel;
        if(first == null){
            first = new IntNode(x, null);
            return;
        }
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }
    private static int size(IntNode p){
        if(p.next == null){
            return 1;
        }

        return 1 + size(p.next);
    }
    public int size(){
        return size(first);
    }

    public int size_two(){
        IntNode p = first;
        int i = 1;
        while(p.next != null){
            p = p.next;
            i = i + 1;
        }
        return i;
    }

    public int fast_size(){
        return size_count;
    }

    public static void main(String[] args){
        SLList L = new SLList(10);
        L.addFirst((10));
        L.addFirst(5);
        L.addLast((20));
        L.size();
        System.out.println(L.first.item);
        System.out.println(L.size());
    }
}

