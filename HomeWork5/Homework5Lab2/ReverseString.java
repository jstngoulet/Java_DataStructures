package Homework5Lab2;

public class ReverseString {

	private static String firstString;
	private static ArrayStack<Character> charStack = new ArrayStack<Character>();
	
	public ReverseString(String toReverse) {
		// TODO Auto-generated constructor stub
		fillStack();
		System.out.println("First String: " + firstString.toLowerCase());
		System.out.println("Reversed: " + reverseString());
		
	}
	
	public static void fillStack()
	{
		for(int i = 0; i < firstString.length(); i++)
		{
			charStack.push(firstString.charAt(i));
		}
	}
	
	public static String reverseString()
	{
		StringBuilder reversed = new StringBuilder();
		while(!charStack.empty())
		{
			//Remove from stack and append to reverse
			reversed.append(charStack.pop());
		}
		
		return reversed.toString().toLowerCase();
	}
	
	public static void main(String[] args)
	{
		firstString = "Race Car";
		new ReverseString(firstString);
	}

}
