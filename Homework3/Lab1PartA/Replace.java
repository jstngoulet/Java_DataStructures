package Lab1PartA;
/**
 * Class takes in an item from an arraylist and replaces it with the second item in the object
 */

/**
 * @author Justin
 *
 */

import java.util.ArrayList;

public class Replace {

	public static ArrayList<String> mainList = new ArrayList<String>();
	
	public static void main(String [] args)
	{
		for(int i = 0; i < 25; i++)
		{
			mainList.add((i+1) + "");
		}
		System.out.println(mainList.toString());
		
		//Now replace
		replaceItem(mainList, "25", "563");
		
		System.out.println(mainList.toString());
	}
	
	/**
	 * 
	 */
	public static void replaceItem(ArrayList<String> list, String oldItem, String newItem) {
		//Get the index (counter)
		int index = list.indexOf(oldItem);
		if(index != -1)
		{
			//Remove Item
			list.remove(index);
			
			//Now, add new item in
			list.add(index, newItem);
		}
	}

}
