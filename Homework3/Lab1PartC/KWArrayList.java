package Lab1PartC;
import java.util.*;

public class KWArrayList<E> {

	//Number Lab 1Part C pg 77 #2
	
	
	private static final int INITIAL_CAPACITY = 10;
	private E[] theData;
	private int size = 0;
	private int capacity = 0;
	
	public KWArrayList(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
		theData = (E[]) new Object[capacity];
	}
	
	public E getIndex(int index)
	{
		if (index < 0 || index >= size)
		{
			throw new ArrayIndexOutOfBoundsException(index);
		}

		return theData[index];
	}

}
