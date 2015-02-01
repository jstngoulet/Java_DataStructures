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
		int curLocation = 0, curMurderer = 0, curWeapon = 0;
		do{
		for(int i = 1; i <= murderers; i++)
		{
			int currentMurdererTheory = Theory.theoryTest3(i, 0, 0);
			//System.out.println("Current murderer: " + currentMurdererTheory);
			if(currentMurdererTheory != 1)
			{
				curMurderer = i;
				//Now checking for the weapon (when the location is correct)
				for(int a = 1; a <= locations; a++)
				{
					int currentLocationTheory = Theory.theoryTest3(curMurderer, a, 0);
					if(currentLocationTheory != 2)
					{
						curLocation = a;
						//Now checking for the murderer
						for(int d = 1; d <= weapons; d++)
						{
							int currentWeaponTheory = Theory.theoryTest3(curMurderer, curLocation, d);
							if(currentWeaponTheory != 3)
							{
								curWeapon = d;
							}
						}
					}
				}
			}
		}
		}while(Theory.theoryTest3(curMurderer, curLocation, curWeapon) != 0);
		
		Theory.checkTheory();
		System.out.println("\n\nLocation: " + curLocation + "\nMurderer: " + curMurderer + "\nWeapon: " + curWeapon);
		System.exit(0);
	}
}
