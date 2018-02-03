import java.util.List;
import java.util.ArrayList;
import edu.princeton.cs.algs4.StdOut;
import java.lang.Integer;

public class BruteCollinearPoints {
    
    private int numSegs = 0;
    private List<LineSegment> list = new ArrayList<LineSegment>();
    private LineSegment[] listArray;
    
    public BruteCollinearPoints(Point[] points){
        if (points == null) {
            throw new  java.lang.IllegalArgumentException();
        }
        
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new  java.lang.IllegalArgumentException ();
            }
            for (int j = i +1; j < points.length; j++) {
                for (int k = j+1; k < points.length; k++) {
                    for (int l = k+1; l < points.length; l++) {
                        if (points[i].slopeTo(points[j]) == points[j].slopeTo(points[k]) && points[j].slopeTo(points[k]) == points[k].slopeTo(points[l])){
                            Point[] temp = {points[i], points[j], points[k], points[l]};
                            Point Pmin = new Point (Integer.MIN_VALUE, Integer.MIN_VALUE);
                            Point Pmax = new Point (Integer.MAX_VALUE, Integer.MAX_VALUE);
                             for (int m = 0; m<4; m++) {
                                 if (temp[m].compareTo(Pmin)>0) {
                                     Pmin = temp[m];
                                 }
                                 if (temp[m].compareTo(Pmax)<0) {
                                     Pmax = temp[m];
                                 }
                             }
                             if (Pmin.compareTo(Pmax)==0){
                                 throw new java.lang.IllegalArgumentException ("Repeated points in argument");
                             } else {
                                  //StdOut.println(Pmin + "->" + Pmax);
                                  Pmin.drawTo(Pmax);
                                  numSegs++;
                                  list.add(new LineSegment(Pmin, Pmax));
                             }                                   
                        }
                    }
                }
            }
        }
        
        listArray = list.toArray(new LineSegment[list.size()]);
    }    // finds all line segments containing 4 points
    
    public           int numberOfSegments() {
        return numSegs;
    }       // the number of line segments
    public LineSegment[] segments()   {
        return listArray;
    }              // the line segments

}