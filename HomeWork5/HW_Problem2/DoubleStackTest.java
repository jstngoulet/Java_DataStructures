package HW_Problem2;

/**
 * 
 * Date last modified: 03.06.2015
 * Function: Tests the DoubleStack class. 
 * This is a stack that has items moving towards each other as it grows.
 * 
 * 
 * @author Justin
 *
 */

public class DoubleStackTest {

	public DoubleStackTest() {
		//This class will test my doubleStack
		//Not sure if I am completely doing what is asking due to misunderstanding
		DoubleStack<String> stack = new DoubleStack<String>();
		
		stack.push(1, "Bob");
		stack.push(1, "Sam");
		stack.push(1, "Fred");
		stack.push(1, "George");
		stack.push(1, "Justin");
		stack.push(0, "Sally");
		stack.push(0, "Barb");
		stack.push(0, "Amber");
		stack.push(0, "Olivia");
		stack.push(0, "Michelle");
		stack.push(0, "Erin");
		
		//Add 2 more
		stack.push(1, "Me");
		stack.push(0, "You");
		
		System.out.println("Size: " + stack.size());
		
		//Peek
		System.out.println("\nPeek: ");
		System.out.println("Stack 1: " + stack.peek(0));
		System.out.println("Stack 2: " + stack.peek(1));
		
		System.out.println("\n\nPop all Items: \n");
		//Show stack
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	}
	
	public static void main(String[] args)
	{
		new DoubleStackTest();
	}

}
