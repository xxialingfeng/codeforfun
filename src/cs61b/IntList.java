package cs61b;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList l){
        first = f;
        rest = l;
    }

    public IntList() {
        /* NOTE: public IntList () { }  would also work. */
        this(0, null);
    }

    public static IntList dcatenate(IntList A, IntList B){
        if (A==null){
            return B;
        }
        if (A.rest == null){
            A.rest = B;
        }
        else {
            A.rest = dcatenate(A.rest, B);
        }
        return A;
    }

    public static IntList catenate(IntList A, IntList B){
        IntList p = new IntList(0,null);
        if(A == null){
            p.first = B.first;
            p.rest = B.rest;
        }
        if(A.rest == null){
            p.first = A.first;
            p.rest = B;
        }
        else{
            p.first = A.first;
            p.rest = catenate(A.rest, B);
        }
        return p;
    }
    public static IntList catenate2(IntList A, IntList B) {
        if (A == null) {
            return B;
        }
        return new IntList(A.first, catenate2(A.rest,B));
    }
    public int get(int i){
        if(i == 0){
            return first;
        }
        return this.rest.get(i-1);
    }
    public static void main(String[] args){
        IntList A = new IntList(5,null);
        IntList B = new IntList(4,null);
        System.out.println(dcatenate(A,B));
        System.out.println(catenate(A,B));
        System.out.println(catenate2(A,B));
//打印出来是一个IntList类，如果要显示出来的话必须用get函数
        }
    }

