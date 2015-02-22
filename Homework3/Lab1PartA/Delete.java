package Lab1PartA;


import java.util.ArrayList;

public class Delete {

	public static ArrayList<String> mainList = new ArrayList<String>();
	
	public static void main(String [] args)
	{
		for(int i = 0; i < 25; i++)
		{
			mainList.add((i+1) + "");
		}
		System.out.println(mainList.toString());
		
		//Now replace
		deleteItem(mainList, "15");
		
		System.out.println(mainList.toString());
	}
	
	public static void deleteItem(ArrayList<String> list, String itemToDelete)
	{
		list.remove(list.indexOf(itemToDelete));
	}

}
