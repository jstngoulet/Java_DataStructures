package Homework5Lab3;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class IntegerStack {

	private static Stack<Integer> list = new Stack<Integer>();
	private static Stack<Integer> list2 = new Stack<Integer>();
	private static Queue<Integer> list3 = new LinkedList<Integer>();
	
	public IntegerStack() {
		// TODO Auto-generated constructor stub
		fillStacks();
		transferStacks();
		removeValues();
	}
	
	public static void fillStacks()
	{
		list.push(-1);
		list.push(15);
		list.push(23);
		list.push(44);
		list.push(4);
		list.push(99);
		
		System.out.println("Top: " + list.peek());
		
	}
	
	public static void transferStacks()
	{
		while(!list.isEmpty())
		{
			//Push into stack 
			Integer temp = list.pop();
			list2.push(temp);
			
			//Push into queue
			list3.offer(temp);
		}
	}
	
	public static void removeValues()
	{
		while(!list2.isEmpty())
		{
		//Remove a value from the second stack and from the queue.
			Integer a = list2.pop();
			Integer b = list3.poll();
		
		//Display the pair of values on a separate output line
			System.out.println("Stack Value: " + a + "\t\tQueue Value: " + b);
			
		}
	}
	
	public static void main(String[] args)
	{
		new IntegerStack();
		
	}

}
