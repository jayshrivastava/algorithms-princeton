import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size = 0;
    public Deque() {
        first = null;
        last = null;
    }                           // construct an empty deque
    
    private class Node { 
        Item a;
        Node previous;
        Node next;
        
        public Node (Item i){
            a = i;
            previous = null;
            next = null;
        }
        
    }
    
    public boolean isEmpty() {
        return first == null;
    }                 // is the deque empty?
    public int size() {
        return size;
    }                        // return the number of items on the deque
    
   public void addFirst(Item item) {
       if (item == null) {
           throw new java.lang.IllegalArgumentException();
       } else {
           Node n = new Node (item);
           size++;
           if (first == null) {
               first = n;
               last = first;
           } else { 
               n.next = first; //FIXED
               first = n;
           }
       }
   }          // add the item to the front
   
   public void addLast(Item item) {
        if (item == null) {
           throw new java.lang.IllegalArgumentException();
       } else {
              Node n = new Node (item);
              size++;
               if (first == null) {//implies last == null
                   first = n;
                   last = first;
               } else { 
                   n.previous = last;
                   last.next = n;
                   last  = n;
               }
       }
   }         // add the item to the end
   
   public Item removeFirst() {
       Item item;
       if (first == null){
           throw new java.util.NoSuchElementException();           
       } else {
           item = first.a;
           first = first.next;
           size--;
           if (first == null){
               last = null; //if there is only one thing in the queue, make sure first and last are both null again;
           } else {
               first.previous = null;
           }
       }
       return item;
   }            // remove and return the item from the front
   public Item removeLast() {
       if (first == null){
           throw new java.util.NoSuchElementException();           
       } else {
           Item item = last.a;
           last = last.previous;
           size--;
           if (last == null){
               first = null;
           } else {
               last.next = null;
           }
            return item;
       }
   }                 // remove and return the item from the end
   public Iterator<Item> iterator() {
       return new ListIterator();
   }// return an iterator over items in order from front to end
   
   private class ListIterator implements Iterator<Item>{
      private Node current = first;
      public boolean hasNext(){
          return current != null;
      }
      public void remove(){
          throw new java.lang.UnsupportedOperationException();
      }
      public Item next (){
          if (!hasNext()){
              throw new java.util.NoSuchElementException();
          }
      Item item = current.a;
      current = current.next;
      size--;
      return item;
      }
   }
   
//   public void print (){
//       Node meme = first;
//       while (meme != null){
//           System.out.println(meme.a);
//           meme = meme.next;
//       }     
//   }
   
   
   public static void main(String[] args) {
//       Deque<Integer> d = new Deque<Integer>();
//       d.addFirst(2);
//       d.addLast(3);
//       d.addLast(4);
//       d.removeFirst();
//       d.removeLast();
//       d.print();
   
   }   // unit testing (optional)
}