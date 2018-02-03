import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private int dimensions;
    private int nTrials;
    private double[] results;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new  java.lang.IllegalArgumentException();
        } else {
            nTrials = trials;
            dimensions= n;
            results = new double [nTrials];

            for (int i = 0; i < trials; i++) {
                Percolation perc = new Percolation(dimensions);
                int opened = 0;
                while (!perc.percolates()) {
                    int row = StdRandom.uniform(1, dimensions + 1);
                    int col = StdRandom.uniform(1, dimensions + 1);
                        if (!perc.isOpen(row, col)) {
                            perc.open(row, col);
                            opened++;
                        }
                }
                double result = (double) opened / (dimensions * dimensions);
                results[i] = result;
            }
        }
    }    // perform trials independent experiments on an n-by-n grid
    
    public double mean(){
        return StdStats.mean(results);
    }// sample mean of percolation threshold
    
    public double stddev() {
        return StdStats.stddev(results);
    }                        // sample standard deviation of percolation threshold
    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(nTrials));
    }                  // low  endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(nTrials));
    }                  // high endpoint of 95% confidence interval

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        
        PercolationStats stats = new PercolationStats(n, T);

        System.out.println("mean                                   = " + stats.mean());
        System.out.println("stddev                                 = " + stats.stddev());
        System.out.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }        // test client (described below)
}
