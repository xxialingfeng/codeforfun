package cs61b;

public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int m = Integer.valueOf(x);
        int n = Integer.valueOf(y);
        if(Math.abs(m-n) == 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        OffByOne obo = new OffByOne();
        System.out.println(obo.equalChars('a', 'b'));
        System.out.println(obo.equalChars('r', 'q'));
    }
}

