package cs61b;

public class OffByN implements CharacterComparator {
    private int diff;
    //new constructor,方便设置想要的数字
    public OffByN(int N){
        N = diff;
    }
    @Override
    public boolean equalChars(char x, char y) {
        if(Math.abs(x - y) == diff){
            return true;
        }
        return false;
    }
}
