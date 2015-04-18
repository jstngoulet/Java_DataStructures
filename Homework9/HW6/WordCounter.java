package HW6;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WordCounter {

	/**
	 * Counts all the words as they appear in a text Document. Stores the word and the line number in which it appears
	 */
	
	public HashMap<String, ArrayList<Integer>> myList;
	public ArrayList<Integer> lineNumberList;
	public Scanner in;
	public int lineNumber = 1;
	
	public WordCounter() {
		myList = new HashMap<String, ArrayList<Integer>>();
		try{
			in = new Scanner(new FileInputStream("TestDoc.txt"));
			create();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Error: \n\n" +  e);
			System.exit(0);
		}
		finally{
			in.close();
		}
	}
	public static void main(String[] args)
	{
		new WordCounter();
	}
	
	public void create()
	{
		while(in.hasNextLine())
		{
			while(in.hasNext())
			{
				String tempKey = in.next();
				try{
					myList.get(tempKey).add(lineNumber);
				}
				catch(NullPointerException e)
				{
					//Does not exist yet
					ArrayList <Integer> tempArr = new ArrayList<Integer>();
					tempArr.add(lineNumber);
					myList.put(tempKey, tempArr);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(new JFrame(), "Error: \n\n" +  e);
					System.exit(0);
				}
			}
		}
		System.out.println("My List:");
		
		for(String str : myList.keySet())
		{
			System.out.print(str + "\t\t\t\t");
			for(int i = 0; i < myList.get(str).size(); i++)
			{
				System.out.print(myList.get(str).get(i) + ", ");
			}
			System.out.println();
		}
	}
	

}
