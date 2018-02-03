import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    private int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }                         // constructs the point (x, y)
    
    private int getX() {
        return x;
    }
    
    private int getY() {
        return y;
    }

    public   void draw() {
        StdDraw.point(x, y);
    }                             // draws this point
   public   void drawTo(Point that) {
       StdDraw.line(this.x, this.y, that.x, that.y);
   }                  // draws the line segment from this point to that point
   public String toString() {
       return "(" + x + ", " + y + ")";
   }                           // string representation

   public  int compareTo(Point that) {
        if (this.y == that.getY() && this.x == that.getX()) 
            return 0;
        if (this.y < that.getY() || (this.y == that.getY() && this.x < that.getX())) 
            return -1;
        return 1;
   }    // compare two points by y-coordinates, breaking ties by x-coordinates
    public double slopeTo(Point that) {
         if (x == that.x) {
             if (y == that.y) return Double.NEGATIVE_INFINITY;
             else return Double.POSITIVE_INFINITY;
         }
        if (y == that.y) return 0;
        double dy = that.y - y;
        double dx = that.x - x;
        return dy/dx;
    }     // the slope between this point and that point
    
    public Comparator<Point> slopeOrder() {
        return new Comparator<Point>() {
            public int compare(Point a, Point b) {
                double m1 = slopeTo(a);
                double m2 = slopeTo(b);
                if (m1 < m2) return -1;
                if (m1 == m2) return 0;
                return 1;
            }
        };
    }         // compare two points by slopes they make with this point
       
//       public static void main(String[] args) {
//       Point a = new Point(2,3);
//       Point b = new Point(4,8);
//       System.out.println(b.slopeTo(a));
//       }
       
}