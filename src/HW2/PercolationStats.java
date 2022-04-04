package HW2;

import java.util.Random;
public class PercolationStats {
    private double[] fractions;
    public PercolationStats(int N, int T, PercolationFactory pf){
       if(N <= 0 || T <= 0){
          throw new IllegalArgumentException();
       }
       Percolation percolation = pf.make(N);
       fractions = new double[N * N];
       for(int i = 0; i <= T; i++) {
           while (!percolation.percolates()) {
               Random random = new Random();
               int r = random.nextInt(N * N);
               int row = r / N;
               int col = r & N;
               percolation.open(row, col);
           }
           int numOfOpen = percolation.numberOfOpenSites();
           double ratio = (double) numOfOpen / N * N;
           fractions[i] = ratio;
       }
    }

    public double mean(){
        return 0;
    }

    public double stddev(){
        return 0;
    }

    public double confidenceLow(){
        return 0;
    }

    public double confidenceHigh(){
        return 0;
    }
}
