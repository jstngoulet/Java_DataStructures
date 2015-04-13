package Homework8_Part1;

import java.awt.List;
import java.util.ArrayList;
import java.util.Comparator;

abstract class Heap<E> {

	public int count;
	public final Comparator<E> comparing;
	public Object[] nodes;
	
	public Heap(int size) {
		this(size, null);
	}
	
	public Heap(int size, Comparator<E> comp)
	{
		this.nodes = new Object[size + 2];
		this.comparing = comp;
		this.count = size;
	}
	
	protected int compare(Object a, Object b) {
	    if (this.comparing == null)
	    {
	    		if(a != null & b != null)
	    			return ((Comparable)a).compareTo((Comparable)b);
	    		else
	    			return -1;
		}
	    else
	      return compare(a, b);
	  }
	
	public Object peek()
	{
		if(count > 0)
			return nodes[0];
		else
			return null;
	}
	
	public int size()
	{
		return count;
	}
	
	public void clear()
	{
		count = removeItem(count);
	}
	
	private int removeItem(int a)
	{
		if(a == 0)
			return 0;
		else
		{
			nodes[a] = null;
			return removeItem(a--);
		}
	}
	
	public final int parent(int i)
	{
		return (i - 1)/2;
	}
	
	public final int left(int i)
	{
		return 2 * i + 1;
	}
	
	public final int right(int i)
	{
		return 2 * (i + 1);
	}
	
	public void print()
	{
		try
		{
			for(int i = 0; i <= nodes.length; i++)
			{
				System.out.println("\n\n\t     " + nodes[parent(i)]);
				System.out.print("\t" + nodes[left(i)]);
				System.out.print("\t   " + nodes[right(i)]);
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			
		}
		
	}
	
	
	abstract void insert(Object o);
	abstract Object extract();
}
