/**
 * 
 */
package miracosta.CS113.hw2;

/**
 * @author Justin
 *
 */
public class Lab2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//y1 = 100 * n  + 10     y^1
		//y2 = 5 * n * n + 2     y^2
		
		/* Write a program that compares the value of y1 and y2 
		 * in the above expressions for the values of up to 100 
		 * in increments of 10. Does the result surprise you?
		 */
		
		int y1 = 0, y2 = 0;
		
		
		for(int n = 0; n < 100; n+= 10)
		{
			//function 1:
			y1 = 100 * n + 10;
			
			//Function 2:
			y2 = 5 * n * n + 2;
			
			System.out.println("Y1: " + y1);
			System.out.println("Y2: " + y2 + "\n");
		}
	}

}
