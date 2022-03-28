package cs61b;

public class Sort {
    public void sort(String[] s){
    sort(s, 0);
    }

    /*sort x starting at position start*/
    /*a helper function*/
    private static void sort(String[] x, int start){
        if(start == x.length){
            return;
        }
        int smallestIndex = findsmallest(x, start);
        Swap(x, start, smallestIndex);
        sort(x, start+1);
    }
    public static int findsmallest(String[] x, int start){
        int smallestIndex = start;
        for(int i = start; i < x.length; i++){
            int cmp = x[i].compareTo(x[smallestIndex]);
            if(cmp < 0){
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
    public static void Swap(String[] x, int a, int b){
        String c = x[a];
        x[a] = x[b];
        x[b] = c;
    }
}
