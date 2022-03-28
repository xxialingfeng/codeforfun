package cs61b;
import java.util.Comparator;

public class DogLaunch {
    public static void main(String[] args) {
        Dog d1 = new Dog("E", 3);
        Dog d2 = new Dog("B", 4);
        Dog[] dogs = new Dog[]{d1, d2};
        Dog.NameComparator nc = new Dog.NameComparator();
        if(nc.compare(d1,d2) > 0){
            d1.bark();
        }else{
            d2.bark();
        }
    }
}
