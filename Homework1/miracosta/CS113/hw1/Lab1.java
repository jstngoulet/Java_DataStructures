/**
 * 
 */
package miracosta.CS113.hw1;

/**
 * @author Justin Goulet
 *
 */
public class Lab1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean found = false;
		
		for(int i = 1; i <= 100; i++)
		{
			if (i % 3 == 0)
			{
				System.out.println("Fuzz " + i);
				found = true;
			}
			else if (i % 5 == 0)
			{
				System.out.println("Buzz " + i);
				found = true;
			}
			
			if((i % 3 == 0) && (i % 5 == 0))
			{
				System.out.println("FizzBuzz " + i);
				found = true;
			}
			
			if (!found)
			{
				System.out.println(i);
				found = true;
			}
			found = false;
		}

	}

}
