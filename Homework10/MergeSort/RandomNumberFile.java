package MergeSort;

import java.io.*;
import java.util.Random;


/**Generates a txt file of random numbers and provides the directory of said file*/
public class RandomNumberFile {
	
	private PrintWriter out;
	
	public RandomNumberFile()
	{
		try{
			out = new PrintWriter(new FileOutputStream("RandomNums.txt"));
			Random aRand = new Random();
			
			for(int i = 0; i < 10000; i++)
			{
				out.println(aRand.nextInt(10000) + 1);
				//System.out.println(i);
			}
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public String getPath()
	{
		return System.getProperty("user.dir") + "/RandomNums.txt";
	}
	
}
