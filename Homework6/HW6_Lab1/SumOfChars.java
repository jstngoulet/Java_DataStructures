package HW6_Lab1;
/**
 * 
 * @author Justin and Group 1
 *
 */
public class SumOfChars {

	public static int toNumber(String n)
	{
		if(n == null || n.equals(""))
			return 0;
		else
			return isDigit(n.charAt(0)) + toNumber(n.substring(1));
	}
	
	public static int isDigit(char letter)
	{
		switch(letter)
		{
		case'1':
			return 1;
		case'2':
			return 2;
		case'3':
			return 3;
		case'4':
			return 4;
		case'5':
			return 5;
		case'6':
			return 6;
		case'7':
			return 7;
		case'8':
			return 8;
		case'9':
			return 9;
		default:
			return 0;
		}
	}
	
	public static void main(String[] args)
	{
		String word = "1jf4i3i5";
		
		System.out.println(toNumber(word));
	}
	
}
