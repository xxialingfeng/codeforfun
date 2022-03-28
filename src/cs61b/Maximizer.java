package cs61b;

public class Maximizer {
    public static OurComparable max(OurComparable[] Items) {
        int maxDex = 0;
        for(int i = 0; i < Items.length; i++){
            int cmp = Items[i].compareTo(Items[maxDex]);
            if(cmp > 0){
                maxDex = i;
            }
        }
        return Items[maxDex];
    }
}
