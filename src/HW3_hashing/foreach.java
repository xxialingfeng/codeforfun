package HW3_hashing;
import java.util.ArrayList;
import java.util.List;
public class foreach {
    public static void main(String[] args){
        int total = 0;
        List<Integer> test = new ArrayList<>();
        test.add(15);
        test.add(50);
        test.add(90);
        for(int x : test){
            total = total * 256;
            System.out.println(total);
            total += x;
            System.out.println(total);
        }
    }
}
