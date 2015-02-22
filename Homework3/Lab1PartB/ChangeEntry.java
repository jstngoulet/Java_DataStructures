package Lab1PartB;
import java.util.ArrayList;


public class ChangeEntry {

	public static ArrayList<DirectoryEntry> theDirectory = new ArrayList<DirectoryEntry>();
	
	public ChangeEntry() {
		// TODO Auto-generated constructor stub
	}
public static String name[] = {"Bob Marley", "Justin Goulet", "Spongebob    ", "Me Awesome", "Eric Phil    "};
public static String number[] = {"123-456-5839", "092-123-5431", "123-342-5421", "123-432-8231", "532-142-3241"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Add a few test items
		for(int i = 0; i < 5; i++)
		{
			theDirectory.add(new DirectoryEntry(name[i], number[i]));
			System.out.println("Name: " + name[i] + "\tNumber: " + number[i]);
		}
		
		
		//Now, add or replace
		addOrChangeDirectory("Bob Marley", "760-555-2311").toString();
		
		for(int i = 0; i < 5; i++)
		{
			System.out.println("Name: " + theDirectory.get(i).getName() + "\tNumber: " + theDirectory.get(i).getNumber());
		}
		
		//Now, test remove
		DirectoryEntry temp = removeEntry("Bob Marley");
		
		//Show what was removed
		System.out.println("\n" + temp.getName() + " " + temp.getNumber() + " was removed!");
		
		System.out.println("New List:\n");
		for(DirectoryEntry tempor : theDirectory)
		{
			System.out.println("Name: " + tempor.getName() + "\tNumber: " + tempor.getNumber());
		}
	}
	
	public static String addOrChangeDirectory(String aName, String newNumber)
	{
		//Determine if exists
		boolean exists = false;
		int index = 0;
		
		//Save index of current name
		for(DirectoryEntry name : theDirectory)
		{
			if(name.getName().contains(aName))
			{
				System.out.println("Bob Found!");
				index = theDirectory.indexOf(name);
				break;
			}
		}
		System.out.println();
		
		if(index != -1)
		{
			DirectoryEntry temp = new DirectoryEntry(aName, newNumber);
			theDirectory.set(index, temp);
			exists = true;
			System.out.println("Name already exists, changing number! " + newNumber.toString() + "\n");
		}
		//If doesn't exist
		else
		{
			//Add to the end
			theDirectory.add(new DirectoryEntry(aName, newNumber));
			System.out.println("New Directory Added");
		}
		
		//Return old number or if a new entry, null
		if(exists)
		{
			return theDirectory.get(index).toString();
		}
		else
		{
			return null;
		}
	}
	
	public static DirectoryEntry removeEntry(String name)
	{
		int index = 0;
		//Save index of current name
		for(DirectoryEntry temp : theDirectory)
		{
			if(temp.getName().contains(name))
			{
				System.out.println("Bob Found!");
				index = theDirectory.indexOf(temp);
				break;
			}
		}
		//System.out.println(index);
		DirectoryEntry toRemove = theDirectory.get(index);
		theDirectory.remove(index);
		
		return /* Entry Removed*/ toRemove;
	}

}
