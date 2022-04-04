package cs61b;

import java.util.Random;
public class ExperimentHelper {
    /** Returns the internal path length for an optimum binary search tree of
     *  size N. Examples:
     *  N = 1, OIPL: 0
     *  N = 2, OIPL: 1
     *  N = 3, OIPL: 2
     *  N = 4, OIPL: 4
     *  N = 5, OIPL: 6
     *  N = 6, OIPL: 8
     *  N = 7, OIPL: 10
     *  N = 8, OIPL: 13
     */
    public static int optimalIPL(int N) {
        int depth = 0;
        int tmp = N;
        int res = 0;
        int numCount = 0;

        while(tmp != 1){
            depth += 1;
            tmp = tmp/2;
        }
        for(int i = 0; i < depth; i++){
            int iIPL = (int) Math.pow(2,i) * i;
            int iNUM = (int) Math.pow(2,i);
            res = res + iIPL;
            numCount = numCount + iNUM;
        }
        int restNums = N - numCount;
        res = res + restNums * depth;
        return res;
    }

    /** Returns the average depth for nodes in an optimal BST of
     *  size N.
     *  Examples:
     *  N = 1, OAD: 0
     *  N = 5, OAD: 1.2
     *  N = 8, OAD: 1.625
     * @return
     */
    public static double optimalAverageDepth(int N) {
        return optimalIPL(N)/N;
    }

    /**
     * Delete one item and insert one item
     * * @param bst BST tree
     */
    public static void insertAndDeleteSuccessor(BST<Integer> bst) {
         Random r = new Random();
         int length = bst.size();
         while(length == bst.size()) {
             int item = r.nextInt(5000);
             if (bst.contains(item)) {
                 bst.deleteTakingSuccessor(item);
             }
         }
         length = bst.size();
         while(length == bst.size()) {
             int item = r.nextInt(5000);
             if (!bst.contains(item)) {
                 bst.add(item);
             }
         }
    }

    public static void insertAndDeleteRandom(BST<Integer> bst) {

        Random r = new Random();
        int length = bst.size();

        // delete an item
        while (length == bst.size()) {
            int item = r.nextInt(5000);
            if (bst.contains(item)){
                bst.deleteTakingRandom(item);
            }
        }

        // insert an item
        length = bst.size(); // size has changed
        while (length == bst.size()) { //写这一行的意义是什么？
            int item = r.nextInt(5000);
            if (!bst.contains(item)){
                bst.add(item);
            }
        }
    }

}
