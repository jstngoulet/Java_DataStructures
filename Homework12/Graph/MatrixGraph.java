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

	HashMap<String, Integer>  graphX;
	HashMap<E, String>  graphY;

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
		
		for(MatrixNode<E, K> item : nodes)
		{
			System.out.println(item.data.toString() + " \t" + item.nodesList.toString());
			for(int i = 1; i <= item.nodesList.size(); i++)
			{
				//System.out.println("Scanning: " + item.nodesList.get(i-1) + " vs. " + matrixGraph[0][i]);
				
				for(int a = 1; a < graphX.size()  + 1; a++)
				{
					//System.out.println("Scanning: " + item.nodesList.get(i-1) + " vs. " + matrixGraph[0][a].trim());
					if((item.nodesList.get(i-1).toString().equals(matrixGraph[0][a])))
					{
						System.out.println("Match: " + (item.nodesList.get(i-1)) + "\tMyInt: " + a);
						matrixGraph[i][a] = "1";
					}
					else
					{
						//matrixGraph[i][a] = "-";
					}
				}
			}
		}
		


	//Print new double array
	String typed = "\n";

	for(int i = 0; i < graphX.keySet().size() + 1; i++)
	{
		for(int a = 0; a <graphX.keySet().size() + 1; a++)
		{
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


	//displayNodes(nodes);
	new MatrixGraph<Integer, Integer>(nodes);	//The Data are ints and the nodes are ints
}

public static void displayNodes(LinkedList<MatrixNode<Integer, Integer>> list)
{
	for(MatrixNode<Integer, Integer> a : list)
	{
		System.out.println(a.toString());
	}
}

}
