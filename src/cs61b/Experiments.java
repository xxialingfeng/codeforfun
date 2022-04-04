package cs61b;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Experiments {
    public static void experiment1() {
            BST<Integer> bst = new BST<>();
            Random r = new Random();
            List<Double> avgDepthMy = new ArrayList<>();
            List<Integer> xValues = new ArrayList<>();
            List<Double> avgDepthOpt = new ArrayList<>();

            for (int i = 0; i <= 5000; i++) {
                int x = r.nextInt(5000);
                if (bst.contains(x)) {
                    continue;
                }

                bst.add(x);
                double thisY = bst.averageDepth();
                xValues.add(i);
                avgDepthMy.add(thisY);
                avgDepthOpt.add(ExperimentHelper.optimalAverageDepth(x));
            }
        }
    public static void experiment2() {
    }

    public static void experiment3() {
    }

    public static void main(String[] args) {
    }
}
