package Graph;
/**
 * @author Justin Goulet
 * @Date May 16, 2015
 * 
 * Notes:
 * 	Please note that I left the log showing that I was able to successfully implenet the graph, with the fault of not being able to stroe the value in teh graph.
 * 	I am showing that my indexes that I locate are correct (MyInt:) , however, when I tried to save the data into the array, it would not save correclty.
 * Probably a simple issue, but I recreated the loop about twenty times trying to figure it out...
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class MatrixGraph<E, K> {

	public static HashMap<String, Integer>  graphX;

	public MatrixGraph(LinkedList<MatrixNode<E, K>> nodes) {


		//Now, let's create our 'graph'
		//This is how it will work:
		//		The data values will be what is displayed going up and down (Rows)
		//		The Nodes are what will be the Column Headers
		//	
		//		we go by each data value, line by line. If the data exists in the nodesList, we display a 1, else 0
		//
		//We have all the x and y values now. Let's use them
		graphX = new HashMap<String, Integer>();
		int iter = 0;
		for(MatrixNode<E, K> item : nodes)
		{
			graphX.put(item.data.toString(), iter);
			iter++;
		}
		String keys[] = new String[graphX.size()];

		int iterate = 0;
		for(String item : graphX.keySet())
		{
			keys[iterate] = item;
			iterate++;
		}


		//Send both to arrays
		String matrixGraph[][] = new String[graphX.keySet().size() + 1][graphX.keySet().size() + 1];
		matrixGraph[0][0] = "";

		int iterator = 1;
		for(MatrixNode<E, K> item : nodes)
		{
			//Add All nodes to both headers
			matrixGraph[iterator][0] = item.data.toString();
			matrixGraph[0][iterator] = item.data.toString();
			iterator++;
		}


		//For each node, we need to check to see if they were added to our array. If they were, we need to get the index of it and place a 1 in the proper location
		for(int i = 0; i < graphX.size() + 0; i++)
		{
			for(K node : nodes.get(i).nodesList)
			{
				if(indexOf(node, matrixGraph) != -1)
				{
					//System.out.println(node.toString() + "  found!");
					matrixGraph[i+1][indexOf(node, matrixGraph)] = "1";
				}
			}
		}


		//Fill in null values
		for(int i = 0; i < graphX.size() + 1; i++)
		{
			for (int d = 0; d < graphX.size() + 1; d++)
			{
				if((matrixGraph[i][d] == null))
				{
					matrixGraph[i][d] = "-";
				}
			}
		}


		printArray(matrixGraph);

	}
	/**
	 * Prints double array as a graph
	 * @param matrixGraph
	 */
	public static void printArray(String matrixGraph[][])
	{
		//Print new double array
		String typed = "\n";

		/**
		 * Prints array
		 */
		for(int i = 0; i < graphX.keySet().size() + 1; i++)	//i = row, a = column
		{
			for(int a = 0; a <graphX.keySet().size() + 1; a++)
			{
				if(a == 1 && i != 0)
				{
					typed+= "|\t";
				}
				else if(i == 0 && a == 1)
				{
					typed+= "\t";
				}
				else if(a == 0 && i == 1)
				{
					typed += "\t";
					for(int d = 0; d < graphX.size(); d++)
					{
						typed += "---------";
					}
					typed += "\n";
				}
				try
				{
					typed += matrixGraph[i][a] + "\t";
				}
				catch(ArrayIndexOutOfBoundsException e)
				{

				}
			}
			typed += "\n";
		}

		System.out.println(typed);
	}
	/**
	 * 
	 * @param data	- 	Item to search for
	 * @param array	-	Array to search in
	 * @return	 			-	index of item in array (-1 if dNE)
	 * 
	 */
	public int indexOf(K data, String array[][])
	{
		int column = 0;

		for(String[] row : array)
		{
			if(row[0].equals(data.toString()))
			{
				//System.out.println("Item: " + data + " \t\tFound @ index: " + column );
				return column;
			}
			column++;
		}
		return -1;
	}

	/**
	 * 
	 * @param args
	 * Runs program with 2 test cases (See complete graphs)
	 */

	public static void main(String[] args)
	{
		//List that will hold all in the graph
		LinkedList<MatrixNode<Integer, Integer>> nodes = new LinkedList<MatrixNode<Integer, Integer>>();

		//Add some test nodes
		//0
		MatrixNode<Integer, Integer> newNode = new MatrixNode<Integer, Integer>(0, new LinkedList<Integer>(Arrays.asList(1, 4)));
		nodes.add(newNode);

		//1
		newNode = new MatrixNode<Integer, Integer>(1, new LinkedList<Integer>(Arrays.asList(0, 4, 3, 2)));
		nodes.add(newNode);

		//2
		newNode = new MatrixNode<Integer, Integer>(2, new LinkedList<Integer>(Arrays.asList(1, 3)));
		nodes.add(newNode);

		//3
		newNode = new MatrixNode<Integer, Integer>(3, new LinkedList<Integer>(Arrays.asList(1, 2, 4)));
		nodes.add(newNode);

		//4
		newNode = new MatrixNode<Integer, Integer>(4, new LinkedList<Integer>(Arrays.asList(0, 1, 3)));
		nodes.add(newNode);


		//displayNodes(nodes);'
		System.out.println("\tPage 572 Self-Check 1A");
		new MatrixGraph<Integer, Integer>(nodes);	//The Data are ints and the nodes are ints

		while(!nodes.isEmpty())
		{
			nodes.removeLast();
		}

		//Make another graph
		//Add some test nodes
		//0
		newNode = new MatrixNode<Integer, Integer>(0, new LinkedList<Integer>(Arrays.asList(1, 4)));
		nodes.add(newNode);

		//1
		newNode = new MatrixNode<Integer, Integer>(1, new LinkedList<Integer>(Arrays.asList(0, 2, 3)));
		nodes.add(newNode);

		//2
		newNode = new MatrixNode<Integer, Integer>(2, new LinkedList<Integer>(Arrays.asList(1, 6)));
		nodes.add(newNode);

		//3
		newNode = new MatrixNode<Integer, Integer>(3, new LinkedList<Integer>(Arrays.asList(1, 5)));
		nodes.add(newNode);

		//4
		newNode = new MatrixNode<Integer, Integer>(4, new LinkedList<Integer>(Arrays.asList(0)));
		nodes.add(newNode);

		//5
		newNode = new MatrixNode<Integer, Integer>(5, new LinkedList<Integer>(Arrays.asList(3)));
		nodes.add(newNode);

		//6
		newNode = new MatrixNode<Integer, Integer>(6, new LinkedList<Integer>(Arrays.asList(2)));
		nodes.add(newNode);


		//displayNodes(nodes);
		System.out.println("\n\n\tPage 559 Self-Check 1B");
		new MatrixGraph<Integer, Integer>(nodes);



		//Add a graph with Chars (to make sure its not just ints
		LinkedList<MatrixNode<String, String>> nodesString = new LinkedList<MatrixNode<String, String>>();

		//Add some test nodes
		//Justin
		MatrixNode<String, String> newNodeString = new MatrixNode<String, String>("Justin", new LinkedList<String>(Arrays.asList("Jaymes", "Daniel")));
		nodesString.add(newNodeString);

		//Jaymes
		newNodeString = new MatrixNode<String, String>("Jaymes", new LinkedList<String>(Arrays.asList("Justin", "Jason")));
		nodesString.add(newNodeString);

		//Daniel
		newNodeString = new MatrixNode<String, String>("Daniel", new LinkedList<String>(Arrays.asList("Justin")));
		nodesString.add(newNodeString);

		//Jason
		newNodeString = new MatrixNode<String, String>("Jason", new LinkedList<String>(Arrays.asList("Jaymes")));
		nodesString.add(newNodeString);

		System.out.println("\n\n\tSitting Arrangements");
		new MatrixGraph<String, String>(nodesString);

	}

	public static void displayNodes(LinkedList<MatrixNode<Integer, Integer>> list)
	{
		for(MatrixNode<Integer, Integer> a : list)
		{
			System.out.println(a.toString());
		}
	}

}
