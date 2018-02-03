import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import edu.princeton.cs.algs4.StdRandom;

public class FastCollinearPoints {
    private int numSegs = 0;
    private LineSegment[] answer;
    
    public FastCollinearPoints(Point[] points) {
        if (points==null) throw new java.lang.IllegalArgumentException ("Null pointer");
        for (int i = 0; i < points.length; i ++){
            if (points[i] == null) throw new java.lang.IllegalArgumentException ("Null element in array");
        }
        Arrays.sort(points);
        for (int j = 0; j < points.length-1; j++){
             if (points[j] == points[j+1]) throw new java.lang.IllegalArgumentException ("Duplicate points");
        }
        
        
        List<LineSegment> lsArr  = new ArrayList<LineSegment>();
        Arrays.sort(points);
        
        for (int i = 0; i < points.length; i++){
               Point[] temp = Arrays.copyOfRange(points, 0, points.length);
               sort(temp, points[i]);
               int repCount = 1;
               Point curr = temp[0];//the point we are considering
               double currSlope = curr.slopeTo(temp[1]);
               for (int j = 2; j < temp.length; j++){
                   if(curr.slopeTo(temp[j])==currSlope && curr.compareTo(temp[j]) < 0){
                       repCount++;
                       if (j==temp.length-1 && repCount >=4){
                            lsArr.add(new LineSegment(curr, temp[j]));
                               numSegs++;     
                       }           
                   } else {
                       if (repCount >=4){
                               lsArr.add(new LineSegment(curr, temp[j-1]));
                               numSegs++;
                           currSlope = curr.slopeTo(temp[j]);
                           repCount =1;        
                       }else {
                           currSlope = curr.slopeTo(temp[j]);
                           repCount =1;
                       }

                   }
               }
        
        }
       
        answer = lsArr.toArray(new LineSegment[lsArr.size()]);

    }    // finds all line segments containing 4 or more points
    
    
    private void sort (Point[] a, Point current){
        Point[] aux = new Point [a.length];
        sort(a, aux, 0, a.length-1, current);
    }
    
    private void sort(Point[] a, Point[] aux, int lo, int hi, Point current){
        if (hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        sort(a, aux, lo, mid, current);
        sort(a, aux, mid+1, hi, current);
        merge(a, aux, lo, mid, hi, current);
    }
    
    private void merge(Point a[], Point aux[], int lo, int mid, int hi, Point current) {
        
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++){
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (current.slopeTo(aux[j]) < current.slopeTo(aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }
    
    public           int numberOfSegments() {
        return numSegs;
    }       // the number of line segments
    public LineSegment[] segments()  {
        return answer;
        
    }             // the line segments
    
    public static void main(String[] args){
         List<Point> a = new ArrayList<Point>();
         for (int i = 0; i < 100; i++){
             Point p = new Point (0,0);
             a.add(p);
         }
//         a.add( new Point (1,102));
         Point[] pointArray = a.toArray(new Point[a.size()]);
   
        FastCollinearPoints fcp = new FastCollinearPoints(pointArray);
        for (int i = 0; i < fcp.numberOfSegments(); i++) {
            System.out.println(fcp.segments()[i].toString());
        }
    } 
}
