package cs61b;

public class RotatingSLList<Item> extends AList<Item>{
    AList<Item> deletedItem;
    public void rotateRight(){
        Item x = removeLast();
        addFirst(x);
    }
    //constructor
    public RotatingSLList(){
        super();
        deletedItem = new AList<Item>();
    }

    public RotatingSLList(Item x){
        super(x);
        deletedItem = new AList<Item>();
    }


    public Item removeLast(){
        Item x = super.removeLast();
        deletedItem.addLast(x);
        return x;
    }

    public void printLostItem(){
        deletedItem.print();
    }
    public static void main(String[] args) {
        RotatingSLList<Integer> rs1 = new RotatingSLList<>();
        rs1.rotateRight();
        rs1.printLostItem();
    }
}
