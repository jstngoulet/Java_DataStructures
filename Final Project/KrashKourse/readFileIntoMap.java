package KrashKourse;

import java.text.DecimalFormat;
import java.util.*;
import java.io.*;



public class readFileIntoMap
{
	//Create arrayLists
	/* ArrayList <MyGameScores> myArrayList = new ArrayList <MyGameScores>();
   ArrayList <String> namesReadFromFile = new ArrayList <String>();*/
	ArrayList <Integer> scoresFromFile = new ArrayList <Integer>();

	HashMap<String, ArrayList<Integer>> data = new HashMap<String, ArrayList<Integer>>();

	//Create arrays from the arraylists
	Set<String> names = null;
	Integer[] scores = null;

	Integer[] newScoresArray;;
	String[] newNamesArray;

	//Create a string that will return all of the player names
	//and scores when the user calls the sendData() method from another class
	String str = "";

	public static void main(String [] args)
	{
		//Calls constructor
		new readFileIntoMap();
	}

	public readFileIntoMap()
	{
		Scanner inputStream = null;
		try
		{
			//Read in scores and names
			inputStream = new Scanner(new FileInputStream("scores.txt"));
		}

		catch(FileNotFoundException e)
		{
			System.exit(0);
		}

		while (inputStream.hasNext())
		{
			//Get the names and scores
			String playerName = inputStream.next();
			int score = inputStream.nextInt();


			//If Hashmap contains ame, add the score to their corresponding arraylist
			if(data.containsKey(playerName))
			{
				ArrayList<Integer> tempScores = data.get(playerName);
				tempScores.add(score);
			}

			//Else, add both items
			else
			{
				ArrayList<Integer> aScoreList = new ArrayList<Integer>();
				aScoreList.add(score);
				data.put(playerName, aScoreList);
			}

			/*namesReadFromFile.add(playerName);*/
			scoresFromFile.add(score);
		}

		//Sort the scores smallest to biggest
		// Collections.sort(scoresFromFile);

		//Put items in an array for sorting
		names = data.keySet();
		scores = scoresFromFile.toArray(new Integer[scoresFromFile.size()]);
		Arrays.sort(scores);

		//calls a recursive method to reverse the scores array
		//to sort biggest to smallest
		reverseArray(scores);

		for(int i = 0; i < data.size(); i++)
		{
			//Match the player names to the scores
			findNameByScore(data, scores[i]);
		}
	}

	//reverses socres array
	public void reverseArray(Integer[] x){
		reverse(x, 0, x.length -1);
	}

	//Recursive method that switches the scores array.
	//I could have used Collections.reverse(scores);, but
	//I implemented recursion instead
	public void reverse(Integer[] x, int i, int j){
		if(i<j)
		{
			//Temp var
			int tmp = x[i];
			x[i] = x[j];
			x[j] = tmp;
			//Keep calling while there are more elements
			reverse(x, ++i, --j);
		}   
	}

	public String sendData()
	{
		//Sends data to class that calls it
		return str;
	}

	public String findNameByScore(HashMap<String, ArrayList<Integer>> names, int score)
	{  
		int i = 0;

		int[] newScoresArray = new int[scoresFromFile.size()];
		String[] newNamesArray = new String[newScoresArray.length];	//Same size arrays because for every score, there is a name

		//For each loop that matches the scores with the player names from the 
		//arraylist
		for(String curName : names.keySet())
		{
			//For each name in our set, scan the list of scores attached to see if 'score' exists
			ArrayList<Integer> curScores = names.get(curName);
			if(curScores.contains(score))
			{
				newNamesArray[i] = curName;
				newScoresArray[i] = score;

				DecimalFormat df = new DecimalFormat("###,###,##0");
				str += "   " + curName + "\t     Score: " + df.format(score) + "\n\n";
				i++;
			}
		}
		//Return the created String
		return str;
	}

}