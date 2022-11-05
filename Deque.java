import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first; // use double linked list implementation

    private Node<Item> last; // points to last node

    private int n; // size of deque

    // create empty deque
    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    // helper class
    private static class Node<Item> {
        private Item item; // item in node
        private Node<Item> next; // next node
        private Node<Item> prev; // previous node
    }

    // construct an empty deque


    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        // similar to stack push()
        if (isEmpty()) { // case if empty
            Node<Item> front = new Node<Item>();
            front.item = item;
            first = front;
            last = first;
            n++;
            return;
        }
        Node<Item> oldFirst = first; // rearrange pointers
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        first.next.prev = first;
        n++; // increment size
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        // similar to enqueue()
        if (isEmpty()) { // case if empty
            Node<Item> front = new Node<Item>();
            front.item = item;
            first = front;
            last = first;
            n++;
            return;
        }
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        oldLast.next = last;
        last.prev = oldLast;
        n++; // increment size
    }

    // remove and return the item from the front
    public Item removeFirst() {
        // similar to stack pop()
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item removed = first.item; // save item being returned
        if (n == 1) { // if 1 item, reset to empty
            first = null;
            last = null;
            n--;
            return removed;
        }
        first = first.next;
        first.prev = null;
        n--;
        return removed;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item removed = last.item;
        if (n == 1) { // if 1 item, reset to empty
            first = null;
            last = null;
            n--;
            return removed;
        }
        last = last.prev;
        last.next = null;
        n--;
        return removed;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node<Item> current = first; // points to current node

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> dq = new Deque<Integer>();
        dq.addFirst(1);
        dq.addLast(2);
        System.out.println(dq.size());
        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
        System.out.println(dq.isEmpty());

        Iterator<Integer> iterator = dq.iterator();

        System.out.println("List elements : ");

        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");

        System.out.println();


    }
}


