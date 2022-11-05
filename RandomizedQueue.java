import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] rq; // resizing array implementation

    private int size; // number of items in rq

    // constructs randomized queue with 1 object
    public RandomizedQueue() {
        size = 0;
        rq = (Item[]) new Object[1];
    }

    // helper method for resizing array
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            copy[i] = rq[i];
        rq = copy;
    }

    // construct an empty randomized queue


    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        // if full, double size
        if (size == rq.length) resize(2 * rq.length);
        rq[size++] = item; // add item at index, then increments size
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        // remove random element
        int random = StdRandom.uniformInt(size);
        Item removed = rq[random];
        if (size == 1) {
            rq[--size] = null;
            return removed;
        }
        rq[random] = rq[size - 1]; // replace with last element in array
        rq[--size] = null; // delete last element
        // if 1/4 full, halve size
        if (size == rq.length / 4) resize(rq.length / 2);
        return removed;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int random = StdRandom.uniformInt(size);
        Item removed = rq[random];
        return removed;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {
        private Item[] copy; // copy of array
        private int index = 0; // keep track of index

        // create randomly shuffled copy of rq
        public RandomIterator() {
            copy = (Item[]) new Object[size];
            for (int i = 0; i < size; i++)
                copy[i] = rq[i];
            StdRandom.shuffle(copy);
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item current = copy[index];
            index++;
            return current;
        }

        public boolean hasNext() {
            return index < size;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rqueue = new RandomizedQueue<Integer>();
        rqueue.enqueue(1);
        System.out.println(rqueue.size());
        rqueue.dequeue();
        System.out.println(rqueue.size());
        rqueue.enqueue(2);
        rqueue.sample();
        System.out.println(rqueue.isEmpty());
        Iterator<Integer> iterator = rqueue.iterator();

        System.out.println("List elements : ");

        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");

        System.out.println();

    }
}


