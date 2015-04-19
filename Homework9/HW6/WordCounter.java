package HW6;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WordCounter {

	/**
	 * Counts all the words as they appear in a text Document. Stores the word and the line number in which it appears
	 */

	public HashtableChain<String, ArrayList<Integer>> myList;
	public ArrayList<Integer> lineNumberList;
	public Scanner in;
	public int lineNumber = 1;

	public WordCounter() {
		myList = new HashtableChain<String, ArrayList<Integer>>();
		try{
			in = new Scanner(new FileInputStream("TestDoc.txt"));
			create();
		}
		catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "All Words Found!");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Error b: \n\n" +  e);
			System.exit(0);
		}
		finally{
			in.close();
			System.exit(0);
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
			try{
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
						JOptionPane.showMessageDialog(new JFrame(), "Erro Ar: \n\n" +  e);
						System.exit(0);
					}
				}
			}
			catch(NullPointerException a)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Error Null: \n\n" +  a);
			}
		}
		System.out.println("\n\nMy List:");
		/**Below works for HashMap impleemtation*/
		/*for(String str : myList.keySet())
		{
			System.out.print(str + "\t\t\t\t");
			for(int i = 0; i < myList.get(str).size(); i++)
			{
				System.out.print(myList.get(str).get(i) + ", ");
			}
			System.out.println();
		}*/
		
		/**This is for HashtableChain*/
		System.out.println("\nList Size: " + myList.size());
		
		for(Entry<String, ArrayList<Integer>> entry : myList.entrySet())
		{
			System.out.println(entry.toString());
		}
	}


}
