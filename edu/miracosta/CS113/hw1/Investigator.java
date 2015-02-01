/**
 * 
 */
package miracosta.CS113.hw1;

import edu.miracosta.cs113.theory.Theory;

/**
 * @author Justin Goulet
 *
 */
public class Investigator {

	public static int weapons = 6, murderers = 6, locations = 10;
	
	/**
	 * @param args
	 */
	//Notes: 	Theory 1 results: 6, 10, 6
	//			Theory 2 results: 1, 1 , 1
	
	//The correct order: murder, location, weapon
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int curLocation = 0, curMurderer = 0, curWeapon = 0, totalChecks = 0;
		int response = Theory.theoryTest3(curMurderer, curLocation, curWeapon);
		
		while(response != 0)
		{
			if(response == 3)
			{
				curWeapon++;
			}
			else if(response == 2)
			{
				curLocation++;
			}
			else if(response == 1)
			{
				curMurderer++;
			}
			totalChecks++;
			response = Theory.theoryTest3(curMurderer, curLocation, curWeapon);
		}
		
		Theory.checkTheory();
		System.out.println("\n\nLocation: " + curLocation + "\nMurderer: " + curMurderer + "\nWeapon: " + curWeapon + "\n\nTotal Checks: " + totalChecks);
		System.exit(0);
	}
}
