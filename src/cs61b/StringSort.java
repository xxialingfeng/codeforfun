package cs61b;
import java.util.Arrays;

public class StringSort {
    public static String Stringsort(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String data = new String(arr);
        return data;
    }

    public static boolean test(){
        return Stringsort("bcs") == Stringsort("sbc");

    }

    public static void main(String[] args){
        System.out.println(Stringsort("bca"));
        System.out.println(test());
    }
}
