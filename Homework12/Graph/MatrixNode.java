package Graph;

import java.util.LinkedList;

public class MatrixNode<E, K> 
{
	public E data;
	public LinkedList<K> nodesList;
	
	/**Creates a node with data and a list pointing to the next nodes*/
	public MatrixNode(E data, LinkedList<K> nextNodes) {
		this.data = data;
		this.nodesList = nextNodes;
	}
	
	public MatrixNode()
	{
		new MatrixNode<Object, Object>(null, null);
	}
	
	public MatrixNode(E data)
	{
		new MatrixNode<Object, Object>(data, null);
	}

	public MatrixNode(LinkedList<K> aList)
	{
		new MatrixNode<Object, K>(null, aList);
	}
	
	public E getData()
	{
		return this.data;
	}
	
	public LinkedList<K> getNextNodes()
	{
		return this.nodesList;
	}
	
	public String toString()
	{
		String temp = "";
		String space = "          ";
		
		temp = "Data: " + data.toString();
		temp += "\t\t|\tList Size: " + getNextNodes().size() + " \t|\tConnected: ";
		
		for(K item : nodesList)
		{
			temp += space + item.toString();
		}
		return temp;
	}
}
