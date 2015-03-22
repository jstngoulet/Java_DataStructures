package HW6_Lab1;
import java.util.*;

public class MyQueue<E> extends LinkedList<E> {

	private static final long serialVersionUID = 1L;
	LinkedList<E> list;

	public MyQueue() {
		// Init linked list
		 list = new LinkedList<E>();
	}
	
	/**
	 * Remove the entry at the front of the queue and returns it if the queue is not empty. 
	 * If it is empty, throw an NoSuchElementException()
	 */
	public E remove()
	{
		if(!list.isEmpty())
		{
			//Return the element at the front and remove it
			return list.removeFirst();
		}
		else
		{
			throw new NoSuchElementException();
		}
	}
	
	public E poll()
	{
		return list.poll();
	}

	/**
	 * Inserts item at rear of queue. 
	 * @return true if successful, false if not
	 */
	public boolean offer(E item)
	{
		return list.offerLast(item);
	}
	
	public E peek()
	{
		return list.peek();
	}
	
	public E element()
	{
		return list.element();
	}
	
	public int size()
	{
		return list.size();
	}
	
	//Now, create a driver
	public static void main(String[] args)
	{
		MyQueue<String> mylist = new MyQueue<String>();
		mylist.offer("This is the best class ever");
		mylist.offer("Hello");
		mylist.offer("Bob");
		
		System.out.println("Peek: " + mylist.peek());
		
		System.out.println("Add item: Fred");
		mylist.offer("Fred");
		System.out.println("\nRemaining Entries: ");
		
		do
		{
			System.out.println("Item: " + mylist.poll());
		}while(mylist.size() > 0);
	}
}
