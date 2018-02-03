import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] system;
    private WeightedQuickUnionUF uf;
    private int size;
    private int first = 0;
    private int last;
    private int numOpen = 0;
   
    public Percolation(int n) {
        if (n <= 0) {
            throw new  java.lang.IllegalArgumentException();
        } else {
            uf = new WeightedQuickUnionUF(n * n + 2);
            last = (n*n + 1);
            size = n;
            system = new int [n][n];
            for (int i = 0; i < n; i++) {
                 for (int j = 0; j < n; j++) {
                     system[i][j] = 0;
                 }
            }
        }
    } // create n-by-n grid, with all sites blocked 
    
    public void open(int row, int col) {
        if (row < 1 || col < 1 || col > size || row > size) {
            throw new  java.lang.IllegalArgumentException();
        } else {
            if (!isOpen(row, col)){
                system[row-1][col-1] = 1;
                numOpen++;
                if (row == 1) {
                    uf.union(getPos(row, col), first);
                }
                if (row == size) {
                    uf.union(getPos(row, col), last);
                }
                if (col > 1 && isOpen(row, col - 1)) {
                    uf.union(getPos(row, col), getPos(row, col - 1));
                }
                if (col < size && isOpen(row, col + 1)) {
                    uf.union(getPos(row, col), getPos(row, col + 1));
                }
                if (row > 1 && isOpen(row - 1, col)) {
                    uf.union(getPos(row, col), getPos(row - 1, col));
                }
                if (row < size && isOpen(row + 1, col)) {
                    uf.union(getPos(row, col), getPos(row + 1, col));
                }
            }
        }
        
        
//        if (row <= 0 || col <= 0 || row > size || col > size) {
//            throw new IllegalArgumentException("YEET");  
//        }
    };    // open site (row, col) if it is not open already
    public boolean isOpen(int row, int col) {
        if (row < 1 || col < 1 || col > size || row > size) {
            throw new  java.lang.IllegalArgumentException();
        } else {
            if (system[row-1][col-1] == 1) {     
                return true;
            }
             return false;
        }
       
    };  // is site (row, col) open?
    public boolean isFull(int row, int col) {
        if (row < 1 || col < 1 || col > size || row > size) {
            throw new  java.lang.IllegalArgumentException();
        } else {
            return uf.connected(first, getPos(row , col)); //FIX
        }
     };  // is site (row, col) full?
    
    public int numberOfOpenSites() {
        return numOpen;
    };       // number of open sites
    
    public boolean percolates() {
//        for (int i = 0; i < size; i++) {
//           for (int j = 0; j < size; j++) {  
//               if (isOpen(1, i+1) && isOpen(size,j+1)) {
////                   System.out.println (i + " " + j);
//                   if (uf.connected(getPos(1, i+1), getPos(size, j+1))) {
//                   return true;
//                   }
//               }
//           }
//        }
        return uf.connected(first, last); //FIX
    }              // does the system percolate?
    
    private int getPos(int row, int col) {
        return size * (row -1 ) + col;
    }
    
//   void print () {
//        for (int i = 0; i<size; i++) {
//            for (int j = 0; j<size; j++) {
//                System.out.print (system[i][j]);
//           }
//           System.out.println(" ");
//        }
//    }

    public static void main(String[] args) {
//     Percolation perc = new Percolation (5);
//       perc.open(1,1);
//       perc.open(2,1);
//       perc.open(3,1);
//       perc.open(4,1);
//       perc.open(5,1);
//       perc.open (5,4);
//  
//   boolean meme = perc.percolates();
//     perc.print();
//    System.out.println("percolates " + meme + " is full: " + perc.isFull(1,1) + " isOpened " + perc.isOpen (5,4));
    }; // test client (optional)
}

 