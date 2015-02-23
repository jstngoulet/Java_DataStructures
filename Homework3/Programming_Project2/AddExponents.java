/**
 * 
 */
package Programming_Project2;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Justin
 *
 */
public class AddExponents {
	public static ArrayList<String> vars = new ArrayList<String>();
	
	public static void main(String args[])
	{
		int increment = 1;
		String temp = "";
		System.out.println("Please input your first expression. To end, please type \"end\"\n");
		while(!temp.equalsIgnoreCase("end"))
		{
			System.out.println("Var " + increment + ": ");
			temp = getVar();
			vars.add(temp);
			increment++;
		}
		
		//Now, for equation 2
		String vars1[] = vars.toArray(new String[vars.size()]);
		vars.clear();
		
		increment = 1;
		System.out.println("Please input your Second expression. To end, please type \"end\"\n");
		while(!temp.equalsIgnoreCase("end"))
		{
			System.out.println("Var " + increment + ": ");
			temp = getVar();
			vars.add(temp);
			increment++;
		}
		
		String vars2[] = vars.toArray(new String[vars.size()]);
	}
	
	public static String getVar()
	{
		Scanner keyboard = new Scanner(System.in);
		return keyboard.nextLine();
	}
	
}
