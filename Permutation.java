import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]); // stores integer
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) { // adds all strings to randomized queue
            queue.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) // prints k random strings
            System.out.println(queue.dequeue());
    }
}
