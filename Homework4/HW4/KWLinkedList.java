/*<listing chapter="2" section="8">*/
package HW4;

import java.util.AbstractSequentialList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Class KWLinkedList implements a double linked list and
 * a ListIterator.
 * @author Koffman & Wolfgang
 **/
public class KWLinkedList<E> extends AbstractSequentialList<E> {
    // Data Fields

    /** A reference to the head of the list. */
    private Node<E> head = null;
    /** A reference to the end of the list. */
    private Node<E> tail = null;
    /** The size of the list. */
    private int size = 0;

    //Methods
// Insert solution to programming exercise 4, section 8, chapter 2 here
    //4
    public void addFirst(E item)
    {
    	add(0, item);
    }
    
    public void addLast(E item)
    {
    	add(getSize(), item);
    }
    
    public E getFirst()
    {
    	return get(0);
    }
    
    public E getLast()
    {
    	return get(getSize());
    }

// Insert solution to programming exercise 3, section 8, chapter 2 here
    //3
    KWLinkedList(Node<E> head, Node<E> tail, int size)
    {
      this.head = head;
      this.tail = tail;
      this.size = size;
      if ( size > 0 )
      {
        tail.next = null;
        head.prev = null;
      }
    }
    
    public int getSize()
    {
    	return this.size;
    }
    
    @Override
	public ListIterator<E> listIterator()
    {
    	return  new KWListIter(0);
    }
    
    public Iterator <E> iterator(int index)
    {
    	return new KWListIter(index);
    }
    
    public static void printList(Node<String> h) {
    	while(h.next != null) {
    		System.out.println(h.data + "->");
    		h = h.next;
    	}
    	System.out.println(h.data );
    }
    /**
     * Add an item at the specified index.
     * @param index The index at which the object is to be
     *        inserted
     * @param obj The object to be inserted
     * @throws IndexOutOfBoundsException if the index is out
     *         of range (i < 0 || i > size())
     */
    @Override
    public void add(int index, E obj) {
    	System.out.println("Add " + obj.toString() + " at: " + index);
        listIterator(index).add(obj);
    }

    /**
     * Get the element at position index.
     * @param index Position of item to be retrieved
     * @return The item at index
     */
    @Override
    public E get(int index) {
        return listIterator(index).next();
    }

    /**
     * Return the size of the list
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    // Inner Classes
    /** 
     * A Node is the building block for a double-linked list.
     */
    private static class Node<E> {

        public Object head;
		/** The data value. */
        private E data;
        /** The link to the next node. */
        private Node<E> next = null;
        /** The link to the previous node. */
        private Node<E> prev = null;

        /**
         * Construct a node with the given data value.
         * @param dataItem The data value
         */
        private Node(E dataItem) {
            data = dataItem;
        }
    } //end class Node

    /** Inner class to implement the ListIterator interface. */
    private class KWListIter implements ListIterator<E> {

        /** A reference to the next item. */
        private Node<E> nextItem;
        /** A reference to the last item returned. */
        private Node<E> lastItemReturned;
        /** The index of the current item. */
        private int index = 0;

        /**
         * Construct a KWListIter that will reference the ith item.
         * @param i The index of the item to be referenced
         */
        public KWListIter(int i) 
        {
            // Validate i parameter.
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException(
                        "Invalid index " + i);
            }
            lastItemReturned = null; // No item returned yet.
            // Special case of last item.
            if (i == size) {
                index = size;
                nextItem = null;
            } else { // Start at the beginning
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }

        /**
         * Construct a KWListIter that is a copy of another KWListIter
         * @param other The other KWListIter
         */
        public KWListIter(KWListIter other) {
            KWListIter itr = new KWListIter(0);
            itr.index = other.index;
            itr.lastItemReturned = other.lastItemReturned;
            itr.nextItem = other.nextItem;
        }

        /**
         * Indicate whether movement forward is defined.
         * @return true if call to next will not throw an exception
         */
        @Override
        public boolean hasNext() {
            return nextItem != null;
        }

        /** Move the iterator forward and return the next item.
        @return The next item in the list
        @throws NoSuchElementException if there is no such object
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        /**
         * Indicate whether movement backward is defined.
         * @return true if call to previous will not throw an exception
         */
        @Override
        public boolean hasPrevious() {
            return (nextItem == null && size != 0)
                    || nextItem.prev != null;
        }

        /**
         * Return the index of the next item to be returned by next
         * @return the index of the next item to be returned by next
         */
        @Override
        public int nextIndex() {
            return index;
        }

        /**
         * Return the index of the next item to be returned by previous
         * @return the index of the next item to be returned by previous
         */
        @Override
        public int previousIndex() {
            return index - 1;
        }

        /**
         * Move the iterator backward and return the previous item.
         * @return The previous item in the list
         * @throws NoSuchElementException if there is no such object
         */
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextItem == null) { // Iterator past the last element
                nextItem = tail;
            } else {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        /**
         * Add a new item between the item that will be returned
         * by next and the item that will be returned by previous.
         * If previous is called after add, the element added is
         * returned.
         * @param obj The item to be inserted
         */
        @Override
        public void add(E obj) {
            if (head == null) { // Add to an empty list.
                head = new Node<E>(obj);
                tail = head;
            } else if (nextItem == head) { // Insert at head.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link it to the nextItem.
                newNode.next = nextItem; // Step 1
                // Link nextItem to the new node.
                nextItem.prev = newNode; // Step 2
                // The new node is now the head.
                head = newNode; // Step 3
            } else if (nextItem == null) { // Insert at tail.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link the tail to the new node.
                tail.next = newNode; // Step 1
                // Link the new node to the tail.
                newNode.prev = tail; // Step 2
                // The new node is the new tail.
                tail = newNode; // Step 3
            } else { // Insert into the middle.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link it to nextItem.prev.
                newNode.prev = nextItem.prev; // Step 1
                nextItem.prev.next = newNode; // Step 2
                // Link it to the nextItem.
                newNode.next = nextItem; // Step 3
                nextItem.prev = newNode; // Step 4
            }
            // Increase size and index and set lastItemReturned.
            size++;
            index++;
            lastItemReturned = null;
        } // End of method add.

        //Insert solution to programming exercise 2, section 8, chapter 2 here
		@Override
		public void set(E item) {
		      if (lastItemReturned == null) {
		        throw new IllegalStateException();
		      }
		      lastItemReturned.data = item;
		    }
		
		// Insert solution to programming exercise 1, section 8, chapter 2 here
		@Override
		public void remove() {
		      if (lastItemReturned == null) {
		        throw new IllegalStateException();
		      }
		      // Unlink this item from its next neighbor
		      if (lastItemReturned.next != null) {
		        lastItemReturned.next.prev = lastItemReturned.prev;
		      }
		      else { // Item is the tail
		        tail = lastItemReturned.prev;
		        if (tail != null) {
		          tail.next = null;
		        }
		        else { // list is now empty
		          head = null;
		        }
		      }
		      // Unlink this item from its prev neighbor
		      if (lastItemReturned.prev != null) {
		        lastItemReturned.prev.next = lastItemReturned.next;
		      }
		      else { // Item is the head
		        head = lastItemReturned.next;
		        if (head != null) {
		          head.prev = null;
		        }
		        else {
		          tail = null;
		        }
		      }
		      // make lastItemReturned null
		      lastItemReturned = null;
		      // decrement both size and index
		      size--;
		      index--;
		    }

    } //end class KWListIter

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return new KWListIter(index);
	}

// Insert solution to programming exercise 1, section 7, chapter 2 here
	public static int indexOf(KWLinkedList<String> myList, Node<String> target)
	{
		//System.out.println("Target to find: " + target.data);
		int index = 0;
		ListIterator <String> myIter = myList.listIterator();
		while(myIter.hasNext())
		{
			//System.out.println("Iter to find: " + myIter.next());
			if(target.data.equalsIgnoreCase(myIter.next()))
			{
				//System.out.println("Item: " + myIter.next() + " found!\nIndex: " + index);
				break;
			}
			else
			{
				index++;
			}
		}
		if (index > myList.size - 1)
		{
			System.out.print(target.data + " is not in list");
			return -1;
		}
		else
		{
			System.out.print(target.data + " is at index: ");
			return index;
		}
	}

// Insert solution to programming exercise 2, section 7, chapter 2 here
	public static int lastIndexOf(KWLinkedList<String> myList, Node<String> target)

	// Insert solution to programming exercise 2, section 7, chapter 2 here
	{
		int index = 0, foundIndex = -1;
		ListIterator <String> myIter = myList.listIterator();
		while(myIter.hasNext())
		{
			if(target.data.equals(myIter.next()))
			{
				foundIndex = index;
			}
			index++;
		}
		if(foundIndex == -1)
		{
			System.out.print(target.data + " not found!");
			return -1;
		}
		else
		{
			System.out.print(target.data + "'s last position is: ");
			return foundIndex;
		}
	}

	// Insert solution to programming exercise 2, section 7, chapter 2 here
	public static <T extends Comparable<T>> int minIndex (KWLinkedList<T> myList) 
	{
		  return myList.indexOf (Collections.min(myList)); 
	}
	
	
	//Main method
    public static void main(String args[])
    {
    	//Insert solution to programming exercise 1, section 6, chapter 2 here
    	Node <String> tom = new Node <String>("Tom");
    	Node <String> dick = new Node <String>("Dick");
    	Node <String> harry = new Node <String>("Harry");
    	Node <String> sam = new Node <String>("Sam");
    	KWLinkedList<String> aList = new KWLinkedList<String>(tom, sam, 4);
    	
    	//Head
    	tom.next = dick;
    	tom.prev = null;
    	
    	//1
    	dick.next = harry;
    	dick.prev = tom;
    	
    	//2
    	harry.next = sam;
    	harry.prev = dick;
    	
    	//3
    	sam.next = null;
    	sam.prev = harry;
    	
    	printList(aList.head);
    	Node<String> bill = new Node <String>("Bill");
    	//Before tom
    	bill.next = tom;
    	aList.head = bill;
    	bill.prev = null;

    	System.out.println("\n\nAdded Bill: ");
    	printList(aList.head);
    	
    	//Insert Sue Before Sam
    	Node <String> sue = new Node<String>("Sue");
    	sue.prev = sam.prev;
    	sam.prev.next = sue;
    	sue.next = sam;
    	sam.prev = sue;
    	
    	
    	System.out.println("\n\nAdded Sue: ");
    	printList(aList.head);
    	
    	//Remove bill
    	aList.head = bill.next;
    	tom.prev = null;
    	bill.next = null;
    	
    	
    	System.out.println("\n\nRemove Bill: ");
    	printList(aList.head);
    	
    	//Remove Sam
    	sue.next = null;
    	sam.next = null;
    	
    	System.out.println("\n\nRemove Sam: ");
    	printList(aList.head);
    	
    	System.out.println("\n\nAdd Tom again: ");
    	Node<String> tom2 = new Node<String>("Tom");
    	tom2.prev = harry.prev;
    	harry.prev.next = tom2;
    	tom2.next = harry;
    	harry.prev = tom2;
    	printList(aList.head);
    	
    	System.out.println("\n\nDone\n");
    	
    	System.out.println(indexOf(aList, tom));
    	System.out.println(lastIndexOf(aList, tom));
    	
    	aList.add("LALA");
    	printList(aList.head);
    	
    }
}
/*</listing>*/