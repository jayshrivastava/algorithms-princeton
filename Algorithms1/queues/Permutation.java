import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
//
//public class Permutation {
//    public static void main(String[] args) {
//        RandomizedQueue<String> randomQ = new RandomizedQueue<String>();
//        
//        int num = Integer.parseInt(args[0]);
//        //StdOut.println(num);
//        int num2 = num;
//        while (num > 0){
//             randomQ.enqueue(StdIn.readString());
//             num--;
//        }
//        while (num2 > 0){
//            StdOut.println(randomQ.dequeue());
//            num2--;
//        }
//    }
//}

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }
        int num = Integer.parseInt(args[0]);
        while(num > 0) {
            StdOut.println(rq.dequeue());
            num--;
        }
    }
}