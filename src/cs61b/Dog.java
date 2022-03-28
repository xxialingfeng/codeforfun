package cs61b;
import java.util.Comparator;

public class Dog implements Comparable<Dog>{

    private String name;
    private int size;

    public Dog(String n, int s){
        name = n;
        size = s;
    }

    public void bark(){
        System.out.println(name + "says : bark ");
    }
    //return -1 if this dog is less than the dog pointed at by o
    @Override
    public int compareTo(Dog o) {
        Dog uddaDog = (Dog) o;//Object没有size，所以要cast一个新Dog
        if (this.size > uddaDog.size) {
            return -1;
        } else if (this.size == uddaDog.size) {
            return 0;
        }
        return 1;
    }
    //不需要初始化，所以可以加static关键字修饰！
    public static class NameComparator implements Comparator<Dog>{
        public int compare(Dog a, Dog b){
            return a.name.compareTo(b.name);
        }
    }
}
