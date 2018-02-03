import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
   private Item[] queue;
   private int length = 0;
   private int nItems = 0;
   
   public RandomizedQueue() {
       Object[] q = new Object[1];
       queue = (Item[]) q;
       length = 1;
   }                // construct an empty randomized queue
   
   public boolean isEmpty() {
       return nItems == 0;
   }                // is the randomized queue empty?
   public int size(){
       return nItems;
   }                        // return the number of items on the randomized queue
   public void enqueue(Item item){
       if (item == null) {
           throw new java.lang.IllegalArgumentException();
       } else {
           queue[nItems] = item;
           //System.out.println("h " + queue[nItems]);
           nItems++;
           //print();
           if (nItems == length){
               length *= 2;
               Object newQueue = new Object[length];
               Item[] nQ = (Item[]) newQueue;
               for (int i = 0; i < nItems; i++) {
                   //System.out.println("h " + queue[i]);
                   nQ[i] = queue[i];
               }
               queue = nQ;
           }
       }    
   }           // add the item
   
   public Item dequeue(){
       if (nItems == 0) {
           throw new java.util.NoSuchElementException();
       } else {
           int rand = StdRandom.uniform(nItems);
           Item i = queue[rand];
           queue[rand] = queue[nItems-1];
           queue[nItems-1] = null;
           nItems --;
           if (nItems == length/4) {
               Item[] newQueue = (Item[]) new Object[length/2];
               for (int j = 0; j < nItems; j++){
                   newQueue[j] = queue[j];
               }
               length = length/2;
           }
           return i;
       }
   }                    // remove and return a random item
   
   public Item sample(){
       if (nItems == 0) {
           throw new java.util.NoSuchElementException();
       } else {
           int rand = StdRandom.uniform(nItems);
           Item i = queue[rand];
           //System.out.println( "yeet " + nItems + " food " + rand);
           return i;
       }
  }                     // return a random item (but do not remove it)
   
   public Iterator<Item> iterator(){  
       return new ListIterator();
   }         // return an independent iterator over items in random order
   
   private class ListIterator implements Iterator<Item> {
         private int current = nItems;
         public boolean hasNext(){
             return current > 0;
         }
         public void remove(){
             throw new java.lang.UnsupportedOperationException();
         }
         public Item next (){
             if (!hasNext()){
                 throw new java.util.NoSuchElementException();
             } else {
                 int rand = StdRandom.uniform(nItems);
                 Item i = queue[rand];
                 return i;
             }
         }
   }
   
//   public void print () {
//      System.out.print("printing: ");
//      for(int i = 0; i <nItems; i++){
//           System.out.print(queue[i] + "  ");
//      }
//       System.out.println("");
//   }
   
   public static void main(String[] args){
//    RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
//         rq.enqueue(3);
//         rq.enqueue(1);
//         rq.enqueue(4);
//          rq.enqueue(3);
//         rq.enqueue(1);
//         rq.enqueue(4);
//        
//         System.out.println( rq.sample());
//           System.out.println( rq.sample());
//             System.out.println( rq.sample());
//               System.out.println( rq.sample());
//               System.out.println( rq.size());
   
   }   // unit testing (optional)
}