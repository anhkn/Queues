Programming Assignment 2: Deques and Randomized Queues


/* *****************************************************************************
 *  Explain briefly how you implemented the randomized queue and deque.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?
 **************************************************************************** */
 For Deque, I decided to use a doubly linked list, because every operation
 needed to be constant time, which wouldn't work if I needed to resize an array.
 The doubly linked list instance variables requires a node for the first and
 last element, with a helper class to define the previous and next node, and an
 integer to keep track of the size. When adding or removing elements,
 I created a new node that contained the item if necessary and rearranged the
 node pointers. When the deque was empty, I used the same process to add the
 item whether addFirst or addLast was used. Likewise, when the deque only had 1
 item, I just reset the pointers to their original value of null whether
 removeFirst or removeLast was used.

 I implemented RandomizedQueue using a resizing array, because the operations
 allowed for amortized time. My instance variables were simply an Item array
 and an integer to keep track of the size. I had a helper class that doubled
 the array size when it was full, and halved it when it was 1/4 full. Enqueueing
 elements was simple, I just added the item to the array. To randomly remove an
 item, I stored the item at a randomly chosen index, replaced it with the last
 element in the array (to fill in the "hole"), then returned the item, resizing
 if necessary. In the case where the array only had 1 item, there was no need
 to randomize or replace. For the iterator I made a randomly shuffled copy of
 the array, and iterated through the copy in order.



/* *****************************************************************************
 *  How much memory (in bytes) do your data types use to store n items
 *  in the worst case? Use the 64-bit memory cost model from Section
 *  1.4 of the textbook and use tilde notation to simplify your answer.
 *  Briefly justify your answers and show your work.
 *
 *  Do not include the memory for the items themselves (as this
 *  memory is allocated by the client and depends on the item type)
 *  or for any iterators, but do include the memory for the references
 *  to the items (in the underlying array or linked list).
 **************************************************************************** */

Randomized Queue:   ~  8n bytes

overhead : 16 bytes
Item[] : has 8 references per object, plus 24 overhead - 8n + 24
int : 4 bytes
padding

8n + 48

Deque:              ~  48n  bytes

overhead : 16 bytes
2 node references : 8 + 8 = 16 bytes
Node inner class : 48 bytes per node - 48n bytes
int : 4 bytes
padding

48n + 40 bytes




/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */
none

/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **************************************************************************** */

Javier Linero and Jeffery Cheng


/* *****************************************************************************
 *  Describe any serious problems you encountered.                    
 **************************************************************************** */
none


/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **************************************************************************** */
none