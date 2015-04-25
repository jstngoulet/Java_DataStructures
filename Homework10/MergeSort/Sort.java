package MergeSort;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * 
 * @author Justin
 * @Date Apr 24 2015
 * 
 * Completed:		Creates a new RandomNumberFile, which writes 10,000 random numbers to a file,
 * 					which is then scanned in and sorted using a merge sort. The output array is then
 * 					printed to a new file, with the added extension of "sorted.txt".
 * 
 * Questions:		Did not understand what it meant by generating two files simultaneously. Does that mean
 * 					Create a new file called "sorted" which is appended every time each section is sorted? If so, how 
 * 					deep into the old array to we append it? The orginal array keeps cutting down, so I wasn't sure how much
 * 					to append in the file while the unsorted file remained.
 *
 */
public class Sort { //Uses mergeSort to sort a file of Strings
	
	Scanner in;
	FileOutputStream out;
	ArrayList<Integer> myInts;
	private static Integer array[];
	
	public Sort(String aFile)
	{
		myInts = new ArrayList<Integer>();
		
		try{
			in = new Scanner(new FileInputStream(aFile));
			if(in != null)
				scan();
		}
		catch(Exception e)
		{
			System.out.println("Cur File: " + aFile);
			e.printStackTrace();
			JOptionPane.showMessageDialog(new JFrame(), "Error Finding File");
			System.exit(0);
		}
		finally{
			//printIntArray();
			
			//Print to a new File as well
			String newFileName = aFile.replace(".txt", "Sorted.txt");
			
			try{
				PrintWriter out = new PrintWriter(new FileOutputStream(newFileName));
				
				for(Integer i : array)
				{
					out.println(i.toString());
				}
				out.close();
			}
			catch(Exception a)
			{
				
			}
		}
	}
	
	public static void printIntArray()
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
	}
	
	public boolean hasNext()
	{
		return in.hasNext();
	}
	
	public void scan()
	{
		while(hasNext())
		{
			//Add nums to an arrawyList, then an array
			myInts.add(in.nextInt());
		}
		array = myInts.toArray(new Integer[myInts.size()]);
		
		//Now, do the merge sort
		/**How does a merge sort work?
		 * 
		 * 	A merge sort works by splitting the file in hal until just two items are compared. Then, as the items are compared,
		 * 		They are placed back into the original array
		 * 
		 */
		mergeSort(array);
	}
	
	public void mergeSort(Integer[] anArray)
	{
		if(anArray.length > 1)
		{
			int tempArraySize = anArray.length/2;	//Cuts array in half for future sorting
			Integer[] leftArray = Arrays.copyOfRange(anArray, 0, tempArraySize);
			Integer[] rightArray = Arrays.copyOfRange(anArray, tempArraySize, anArray.length);
			
			mergeSort(leftArray);
			mergeSort(rightArray);
			
			merge(anArray, leftArray, rightArray);
		}
	}
	
	public static void merge(Integer[] arrayStart, Integer[] arrayA, Integer[] arrayB)
	{
		int sizeOfArray = arrayA.length + arrayB.length;	//Size of complete array (array start size changes)
		
		int arrayStartIterator, leftArrayIterator, rightArrayIterator;
		arrayStartIterator = leftArrayIterator = rightArrayIterator = 0;	//Set all to zero
		
		while(arrayStartIterator < sizeOfArray)
		{
			if(leftArrayIterator < arrayA.length && rightArrayIterator < arrayB.length)
			{
				if(arrayA[leftArrayIterator] < arrayB[rightArrayIterator])
				{
					arrayStart[arrayStartIterator] = arrayA[leftArrayIterator];
					arrayStartIterator++;
					leftArrayIterator++;
				}
				else
				{
					arrayStart[arrayStartIterator] = arrayB[rightArrayIterator];
					arrayStartIterator++;
					rightArrayIterator++;
				}
			}
			else
			{
				if(leftArrayIterator >= arrayA.length)
				{
					while(rightArrayIterator < arrayB.length)
					{
						arrayStart[arrayStartIterator] = arrayB[rightArrayIterator];
						arrayStartIterator++;
						rightArrayIterator++;
					}
				}
				if(rightArrayIterator >= arrayB.length)
				{
					while(leftArrayIterator < arrayA.length)
					{
						arrayStart[arrayStartIterator] = arrayA[leftArrayIterator];
						leftArrayIterator++;
						arrayStartIterator++;
					}
				}
			}
		}
	}
	
	
	
	
	public static void main(String[] args)
	{
		RandomNumberFile ran = new RandomNumberFile();
		new Sort(ran.getPath());
		JOptionPane.showMessageDialog(new JFrame(), "File created: " + ran.getPath());
	}

}

