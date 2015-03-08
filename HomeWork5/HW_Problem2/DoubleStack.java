package HW_Problem2;
import java.util.*;


public class DoubleStack<E> extends ArrayList<E>{

	/*
	private Stack<E> stack0, stack1;

	public DoubleStack() {
		// init Stacks
		stack0 = new Stack<E>();
		stack1 = new Stack<E>();
	}
	
	//Now basic methods (peek, empty, popm push(E))
	public boolean isEmpty(int stackNum)
	{
		return getStack(stackNum).isEmpty();
	}

	public E peek(int stackNum)
	{
		return getStack(stackNum).peek();
	}
	
	private Stack<E> getStack(int num)
	{
		if(num == 0)
		{
			return stack0;
		}
		else
		{
			return stack1;
		}
	}

	public E pop(int stackNum)
	{
		return getStack(stackNum).pop();
	}

	public E push(int stackNum, E item)
	{
		return getStack(stackNum).push(item);
	}
	
	@Override
	public int size()
	{
		return stack0.size() + stack1.size();
	}
	
	@Override
	public E push(E item)
	{
		//If no stack input, assume its the first
		return getStack(0).push(item);
	}*/
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Use arraylists for this implementation;
	/**Plan:
	 * 	Create one arraylist that always adds from the top
	 * 	Create another that adds from the bottom
	 * 
	 * 	Becuase they can be filled, they need an initial capactity. Let's say ten
	 * 	So, that means that when the stack size == 10, our double stack is full.
	 * 		It does not matter if 1 has 8 and the other 2, both 5, or 1 and 9.
	 */
	//Init Arraylists
	ArrayList<E> list, list1;
	
	public DoubleStack()
	{
		//Init lists
		list = new ArrayList<E>();
		list1 = new ArrayList<E>();
	}

	public E peek(int index)
	{
		//If list 1, we peek from the top. 
		if(index == 1)
		{
			return list.get(list.size() - 1);
		}
		
		//If list 2, we peek from the bottom
		else{
			return list1.get(0);
		}
	}
	
	public E pop()
	{
		//We need to combine the lists and get the top value here
		ArrayList<E> temp = new ArrayList<E>();
		for(E i:list)
		{
			temp.add(i);
		}
		for(E i: list1)
		{
			temp.add(i);
		}
		
		//Return top value
		E item = temp.get(0);

		//Now that we have the value we want to remove, we have to find the list the value is in
		if(list.contains(item))
		{
			list.remove(item);
		}
		else if(list1.contains(item))
		{
			list1.remove(item);
		}
		
		return item;
	}
	
	public void push(int index, E item)
	{
		//Get sizes of arrays
		int size1 = list.size();
		int size2 = list1.size();
		
		//Subtract to get remaining possible sizes
		int totSize = size1+size2;
		//System.out.println("Size: " + totSize);
		
		if(index == 0)
		{
			if(totSize <= 100 || isEmpty())
			{
				list.add(list.size(), item);
			}
			else
			{
				System.out.println("Size is too great: " + totSize + " item: " + item);
				throw new IndexOutOfBoundsException();
			}
		}
		else
		{
			if(totSize <= 100 || isEmpty())
			{
				list1.add(0, item);
			}
			else
			{
				System.out.println("Size is too great: " + totSize + " item: " + item);
				throw new IndexOutOfBoundsException();
			}
		}
	}

	public boolean isEmpty()
	{
		if(list1.size() + list.size() == 0)
		{
			return true;
		}
		else
			return false;
	}
	
	public int size()
	{
		return list1.size() + list.size();
	}
	
	
	
}
