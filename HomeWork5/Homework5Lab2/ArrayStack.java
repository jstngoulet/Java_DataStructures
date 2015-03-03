package Homework5Lab2;
import java.util.ArrayList;
import java.util.*;


public class ArrayStack<E>
{
	private ArrayList<E> list;
	
	public ArrayStack() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<E>();
	}
	
	public boolean empty()
	{
		if(list.size() > 0)
		{
			return false;
		}
		else
			return true;
	}
	/**
	 * returns the object at the top of the stack and removes it. Throws StackEmptyException if empty
	 * @return the object at the top
	 */
	public E pop()
	{
		E obj = null;
		if(list.size() == 0)
		{
			throw new EmptyStackException();
		}
		else
		{
			obj = list.get(0);
			list.remove(0);
		}
		return obj;
	}
	/**
	 * pushes the value to the top of the stack and moves everything lse to the end
	 * @param obj - Item to be inserted
	 * @return the object inserted
	 */
	public E push(E obj)
	{
		list.add(0, obj);
		return obj;
	}
	/**
	 * REturns the object at the top of the stack not changing anythin
	 * @return the object at the top of the stack
	 */
	public E peek ()
	{
		return list.get(0);
	}
	
	public static void main(String[] args)
	{
		ArrayStack<String> typeList = new ArrayStack<String>();
		for(int i = 1; i <= 10; i++)
		{
			typeList.push(i + "");
		}
		
		//Now test
		System.out.println("Is Empty: " + typeList.empty());
		System.out.println("Val at head: " + typeList.peek());
		System.out.println("Remove head: " + typeList.pop());
		System.out.println("Add Value 23: " + typeList.push("23") + "\n\n");
		
		//Now check the remainder
		while(!typeList.empty())
		{
			System.out.println("Removed Value: " + typeList.pop());
		}
		System.out.println("\nIs Empty: " + typeList.empty());
		
		//Now, use the first lab with this class (See lab in package);
	}

}
