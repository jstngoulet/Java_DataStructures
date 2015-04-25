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
 * @Date Apr 25 2015
 * 
 * Completed:		Creates a new RandomNumberFile, which writes 10,000 random numbers to a file,
 * 					which is then scanned in and sorted using a merge sort. The output array is then
 * 					printed to a new file, with the added extension of "sorted.txt".
 * 
 * Questions:		Updated the file output management, however, does not sort complete file as expected.
 * 					In my Scan method, I placed the code and comments for what I was trying to do. My logic 
 * 					followed the merge sort algorithim I completed in a previous version (it workd, but only created a file,
 * 					read in items to an array, sorted, and exported to a sorted file) and did not work. My current 
 * 					program only seems  to combine the twp out.txt files instead of sorting (not sure why)
 *
 */
public class Sort { //Uses mergeSort to sort a file of Strings
	
	Scanner in;
	Scanner in1, in2;
	FileOutputStream out;
	ArrayList<Integer> myInts;
	PrintWriter outer1, outer2, outerFin;
	private static Integer myAr1[], myAr2[];
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
		/**For regular merge sort
		while(hasNext())
		{
			//Add nums to an arrawyList, then an array
			myInts.add(in.nextInt());
		}
		array = myInts.toArray(new Integer[myInts.size()]);
		*/
		//Now, do the merge sort
		/**How does a merge sort work?
		 * 
		 * 	A merge sort works by splitting the file in hal until just two items are compared. Then, as the items are compared,
		 * 		They are placed back into the original array
		 * 
		 */
		
		//For out merge sort: Read in ten values at a time, from the first file and alternate output to 
		//2 sorted array files
		String file1Name = "out1.txt", file2Name = "out2.txt";
		try{
			outer1 = new PrintWriter(new FileOutputStream(file1Name, true));
			outer2 = new PrintWriter(new FileOutputStream(file2Name, true));
			outerFin = new PrintWriter(new FileOutputStream("SortedData.txt"));
		}
		catch(Exception e)
		{
			showError(e.getMessage());
		}
		
		int iter = 0;
		while(hasNext())//Checks orignial file for next value
		{
			ArrayList <Integer> aList = new ArrayList<Integer>();
			
			if(iter % 2 == 0) //Even
			{
				for(int i = 0; i < 10; i++)
				{
					if(hasNext())
					{
						aList.add(in.nextInt());
					}
				}
			}
			else
			{
				for(int i = 0; i < 10; i++)
				{
					if(hasNext())
					{
						aList.add(in.nextInt());
					}
				}
			}
			//Sort the ten item arrays then place in corresponding file
			//Then, 
			array = mergeSort(aList.toArray(new Integer[aList.size()]));
			
			//Print in corresponding file
			if(iter % 2 == 0)
			{
				for(int i = 0; i < array.length; i++)
				{
					outer1.println(array[i]);
				}
			}
			else
			{
				for(int i = 0; i < array.length; i++)
				{
					outer2.println(array[i]);
				}
			}
			iter++;
		}
		outer1.close();
		outer2.close();
		
		//Now that we have our 2 files, we get ten items from each file, add them to an array and mergesort them, 
		//	which is then output to our final file.
		
		try
		{
			in1 = new Scanner(new FileInputStream("out1.txt"));
			in2 = new Scanner(new FileInputStream("out2.txt"));
		}
		catch(Exception a)
		{
			showError(a.getMessage());
		}
		
		//We created out input scanners, now read ten lines and merge
		while(in1.hasNext() || in2.hasNext())
		{
			ArrayList <Integer> list1 = new ArrayList<Integer>();
			ArrayList <Integer> list2 = new ArrayList<Integer>();
			ArrayList <Integer> maxList;
			
			if(in1.hasNext())
			{
				for(int i = 0; i < 10; i++)
				{
					if(in1.hasNext())
					{
						list1.add(in1.nextInt());
					}
				}
				myAr1 = mergeSort(list1.toArray(new Integer[list1.size()]));
			}
			else	//in2 has next by default
			{
				for(int i = 0; i < 10; i++)
				{
					if(in2.hasNext())
					{
						list2.add(in2.nextInt());
					}
				}
				myAr2 = mergeSort(list2.toArray(new Integer[list2.size()]));
			}
			
			//Now we need to merge our two sorted arrays. First, let's add them together in 1 array
			maxList = new ArrayList<Integer>();
			
			if(myAr1 != null)
			{
				for(int i = 0; i < myAr1.length; i++)
				{
					maxList.add(myAr1[i]);
				}
			}
			
			if(myAr2 != null)
			{
				for(int i = 0; i < myAr2.length; i++)
				{
					maxList.add(myAr2[i]);
				}
			}
			
			//Store in first array and sort
			Integer[] newArray = mergeSort(maxList.toArray(new Integer[maxList.size()]));
			
			//Print to file
			for(Integer i : newArray)
			{
				outerFin.println(i);
			}
			
		}
		outerFin.close();
		
		

		//System.exit(0);
		//For merge sort solely
		//mergeSort(array);
		
	}
	
	public Integer[] mergeSort(Integer[] anArray)
	{
		if(anArray.length > 1)
		{
			//Update 
			
			int tempArraySize = anArray.length/2;	//Cuts array in half for future sorting
			Integer[] leftArray = Arrays.copyOfRange(anArray, 0, tempArraySize);
			Integer[] rightArray = Arrays.copyOfRange(anArray, tempArraySize, anArray.length);
			
			mergeSort(leftArray);
			mergeSort(rightArray);
			
			return merge(anArray, leftArray, rightArray);
		}
		return anArray;
	}
	
	public static Integer[] merge(Integer[] arrayStart, Integer[] arrayA, Integer[] arrayB)
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
		return arrayStart;
	}
	
	public void showError(String e)
	{
		JOptionPane.showMessageDialog(new JFrame(), e);
		System.exit(0);
	}
	
	
	public static void main(String[] args)
	{
		RandomNumberFile ran = new RandomNumberFile();
		new Sort(ran.getPath());
		JOptionPane.showMessageDialog(new JFrame(), "File created: \n" + ran.getPath());
		System.exit(0);
	}

}

