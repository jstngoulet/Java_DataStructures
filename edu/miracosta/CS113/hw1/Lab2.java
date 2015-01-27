/**
 * 
 */
package miracosta.CS113.hw1;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 * @author Justin Goulet
 *
 */
public class Lab2 {

	/**
	 * @param args
	 * This program takes in a number from the user and checks to see if it is a power of 2.
	 * I use a JoptionPane to get the number, a try-catch to see if the number is valid, and a JoptionPane
	 *      to allow the user to see the final result
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int responseInt = 0;

		while (responseInt == 0) {
			String response = JOptionPane
					.showInputDialog("Please Input a Number: ");

			try {
				responseInt = Integer.parseInt(response);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "Please input a valid number!");
			}
		}

		// Now, check if number is a power of 2
		int root = checkRoot(responseInt);
		//System.out.println(root);
		if(root == 2)
		{
			JOptionPane.showMessageDialog(new JFrame(), responseInt + " is a root of 2!");
		}
		else
		{
			JOptionPane.showMessageDialog(new JFrame(), responseInt + " is not a root of 2!");
		}
		System.exit(0);

	}

	/**
	 * @param num is the variable that is dividing. If the final result is 2, the number is a power of 2
	 * @return the final number. If 2, the number input is a power
	 */
	public static int checkRoot(int num) {
		// Check to see if the number is equivalent to a number to the power of
		// 2 (2 ^ x)
		//System.out.println(num);
		if(num > 2)
		{
			num = checkRoot(num/2);
		}
		else
		{
			return num;
		}
		return num;
	}

}
