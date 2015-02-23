/**
 * 
 */
package Programming_Project3;
import java.util.*;

/**
 * @author Justin
 *
 */
public class Registration {

	public static ArrayList <String> students = new ArrayList<String>();
	public static Scanner keyboard;
	public static String s = "\n\nPlease type a command: \n\n1) Add Student to Front \t2) Add Student to Back\n3) Remove first student \t4) Remove by Name\n5) Show List\t\t\t6) Sort Names";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Database currently empty. Please add some names");
		students.add(getName());
		showList();
		getCommand();
	}
	
	/**
	 * 
	 */
	public static void addStudentToBack()
	{
		System.out.println("Please enter a student for the list: (First Last)");
		students.add(getName());
		getCommand();
	}
	
	/**
	 * 
	 */
	public static void addStudentToFront()
	{
		System.out.println("Please enter a student for the list: (First Last)");
		students.add(0, getName());
		getCommand();
	}
	
	/**
	 * 
	 */
	public static void showList()
	{
		System.out.println("\nCurrent Names in directory: ");
		for(int i = 0; i < students.size(); i++)
		{
			System.out.println("Name: " + students.get(i));
		}
		getCommand();
	}
	
	/**
	 * 
	 */
	public static void sortList()
	{
		Collections.sort(students);
		System.out.println("Names Sorted Alphebetically!");
		getCommand();
	}
	
	/**
	 * 
	 */
	public static void getCommand()
	{
		System.out.println(s);
		int command = getOption();
		//Now use the command
				switch(command)
				{
				case 1:
				     addStudentToFront();
					break;
				case 2:
					addStudentToBack();
					break;
				case 3:
					removeFirstStudent();
					break;
				case 4:
					removeByName();
					break;
				case 5:
					showList();
					break;
				case 6:
					sortList();
				default:
					break;
				}
	}
	
	/**
	 * 
	 */
	public static void removeFirstStudent()
	{
		System.out.println(students.get(0) + " Removed!");
		students.remove(0);
	}
	
	/**
	 * 
	 */
	public static void removeByName()
	{
		System.out.println("Type a name to remove");
		String nameToRemove = getName();
		boolean a = students.remove(nameToRemove);
		if(a)
			System.out.println("Name Removed!");
		else
			System.out.println("Name Not Found!");
		getCommand();
	}
	
	/**
	 * @return
	 */
	public static String getName()
	{
		keyboard = new Scanner(System.in);
		String name = keyboard.nextLine();
		return name;
	}
	
	/**
	 * @return
	 */
	public static int getOption()
	{
		int option = 0;
		while (option == 0)
		{
			try{
				keyboard = new Scanner(System.in);
				option = keyboard.nextInt();
				if(option > 6 || option < 0)
				{
					option = 0;
				}
			}
			catch(InputMismatchException e)
			{
				option = 0;
				System.out.println("Please make a valid selection");
			}
		}
		return option;
	}
}

