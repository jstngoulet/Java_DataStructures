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
		
		for(int i = 0; i < 100; i++)
		{
			if (i % 3 == 0)
			{
				System.out.println("Fuzz " + i);
			}
			if (i % 5 == 0)
			{
				System.out.println("Buzz " + i);
			}
			
			if((i % 3 == 0) && (i % 5 == 0))
			{
				System.out.println("FizzBuzz " + i);
			}
		}

	}

}
