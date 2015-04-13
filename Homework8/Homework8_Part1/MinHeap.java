package Homework8_Part1;

/**
 * Justin Goulet
 * CS 113 
 * Date Last Modified: April 12, 2015
 */


/**
 * Only prints trees as subtrees (eg       a			)
 * 															b   c
 */

import java.util.Comparator;

public class MinHeap<E> extends Heap<E> {

	public MinHeap(int size) {
		super(size);
		// TODO Auto-generated constructor stub
	}
	
	public MinHeap(int size, Comparator<E> compare)
	{
		super(size, compare);
	}
	

	@Override
	void insert(Object o) {
		
		if(count >= nodes.length)
		{
			int cap = 3 * nodes.length / 2 + 1;		//Add new level to tree
			Object[] newNodes = new Object[cap];
			System.arraycopy(nodes, 0, newNodes, 0, nodes.length);//Copy old array to new array
			nodes = newNodes;
		}
		
		int temp = count;
		count ++;
		while(temp > 0)
		{
			int myParent = parent(temp);	//Finds the parent of the currnt value
			if(compare(o, nodes[myParent]) < 0)
			{
				nodes[temp] = nodes[myParent];	//Replace the current node to that of its parent
				temp = myParent;		//Changes the new parent value
			}
			else
				break;	//No more parents
			
		}
		
		nodes[temp] = o;	//Set the new object at the parent value
		
	}

	@Override
	Object extract() {
		if(count < 1)
			return null;
		else
		{
			int index = 0;	//Top element
			Object least = nodes[index];	//Takes the object at the top and sets it to the currrent object
			count--;
			Object newRoot = nodes[count]; //Move next object up
			nodes[count] = null;
			
			//Loop through the tree and shift everything that needs to, up.
			int l , r, child;
			
			for(Object i : nodes)
			{
				 l = left(index);
				 
				 if(l >= count)
				 {
					 break;	//None left
				 }
				 else{
					 //Set right to value right of parent
					 r = right(index);
					 
					 //How do we get the child?
					 /* Logic - 
					  * 		We need to make sure a right child exists, so let's 
					  * 			first make sure that the right side is greater than that
					  * 			of the count. Secondly, we need to ensure that the compare values
					  * 			match that of our current style heap. In this case, we have a Min heap,
					  * 			So is is exactly backwards sorting from a Max Heap.
					  * 				Then, once we have the value, we know it will return either a 1 or 0, 
					  * 				so we can use it to see if the child = 1 : 1 or 1 : 0
					  * 
					  * 		This logic can be broken down into a single line of code:
					  */
					 child = (r >= count || compare(nodes[l], nodes[r]) < 0)? l : r;
					 
					 //Print to test
					 System.out.println("Child: " + child);
					 
					 if(compare(newRoot, nodes[child]) < 0)
					 {
						 nodes[index] = nodes[child];	//Set node at parent to the value of the child
						 index = child;	//Save the value of the child into the current index
					 }
				 }
			}
			
			
			nodes[index] = newRoot;
			return least;
		}
	}

}
