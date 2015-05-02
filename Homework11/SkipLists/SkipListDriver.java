package SkipLists;

/**
 * 
 * @author Justin
 *@Date	May2, 2015
 */

public class SkipListDriver {

	public SkipListDriver() {
		// Test the Skip List functionality
		SkipList<Integer> myList = new SkipList<Integer>();
		
		for(int i = 0; i < 100; i++)
		{
			if(i % 3 == 0 && i % 5 ==0)
			{
				myList.add(i);
			}
		}
		
		System.out.println(myList);
		
		//Now that we have a list, let's check it for a value
		if(myList.contains(15))
		{
			System.out.println("\n15 Found!");
		}
		
		for(int i = 0; i < 100; i++)
		{
			if(i%10 ==0)
			{
				//Remove every other item
				myList.remove(i);
			}
		}
		System.out.println("\nRemoved Every other item: \n" + myList);
	}
	
	public static void main(String[] args)
	{
		new SkipListDriver();
	}

}
