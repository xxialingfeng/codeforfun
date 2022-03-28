package cs61b;

public class HofDemo {
    public static int do_twice(IntUnaryFunction f, int x){
        return f.apply(f.apply(x));
    }

    public static void main(String[] args){
        IntUnaryFunction Tenx = new tenX();
        System.out.println(do_twice(Tenx, 2));
    }
}
