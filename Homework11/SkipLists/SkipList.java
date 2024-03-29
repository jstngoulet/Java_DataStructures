package SkipLists;

import java.util.Arrays;
import java.util.Random;

/**
 * A Skip List is an alternative to a binary tree that provides for
 * approximately logorithmic searching, insertion, and deletion.
 * Skip Lists were developed by William Pugh and first described in
 * "Skip Lists: A Probabilistic Alternative to Balanced Treees",
 * CACM 13:8 (June 1990) pp 668-676
 * @author Koffman & Wolfgang
 * 
 * Edited by:
 * 
 * @author Justin
 *@Date	May2, 2015
 *
 *Added functionality: Add/remove an item from the list
 */
public class SkipList<E extends Comparable<E>> {

    /** Static class to contain the data and the links */
    static class SLNode<E> {

        SLNode<E>[] links;
        E data;
		public E item;
		@SuppressWarnings("rawtypes")
		public SLNode[] next;

        /** Create a node of level n */
        @SuppressWarnings("unchecked")
        SLNode(int n, E data) {
            links = (SLNode<E>[]) new SLNode[n];
            this.data = data;
        }

		public int level() {
			// TODO Auto-generated method stub
			return links.length;
		}
    }
    /** Maximum level */
    int maxLevel = 2;
    /** Nominal maximum capacity */
    int maxCap = computeMaxCap(maxLevel);
    /** Natural Log of 2 */
    static final double LOG2 = Math.log(2.0);
    /** A random number generator */
    final static Random rand = new Random();
    /** The current size of the skipList */
    int size;

    /**
     * Method to compute the maximum capacity, given the maximum
     * level. It computes Math.pow(2, maxLevel) - 1, using shift.
     * @return Math.pow(2, maxLevel+1) - 1;
     */
    private static int computeMaxCap(int maxLevel) {
        return ~(~0 << maxLevel);
    }

    /**
     * Method to generate a lograthmic distributed integer between
     * 1 and maxLevel.  I.E. half of the values returned are 1, 1/4
     * are 2, 1/8 3, 1/16 4, etc.
     * @return a random lograthmic distributed int between 1 and maxLevel
     */
    private int logRandom() {
        int r = rand.nextInt(maxCap);
        int k = (int) (Math.log(r + 1) / LOG2);
        if (k > maxLevel - 1) {
            k = maxLevel - 1;
        }
        return maxLevel - k;
    }
    /** The head node is a dummy node, it contains no data */
    SLNode<E> head = new SLNode<E>(maxLevel, null);

    /*<listing chapter="9" number="7">*/
    @SuppressWarnings("unchecked")
    /**
     * Search for an item in the list
     * @param item The item being sought
     * @return A SLNode array which references the nodes
     *         preceeding the sought item at each level.
     */
    private SLNode<E>[] search(E item) {
        SLNode<E>[] result = (SLNode<E>[]) new SLNode[maxLevel];
        SLNode<E> current = head;
        for (int i = current.links.length - 1; i >= 0; i--) {
            while (current.links[i] != null
                    && current.links[i].data.compareTo(item) < 0) {
                current = current.links[i];
            }
            result[i] = current;
        }
        return result;
    }

    /**
     * Find an object in the skip list
     * @param target The item being sought
     * @return A reference to the object in the skip list that compares
     *         equal as determined by compareTo to the target. If not
     *         found null is returned.
     */
    public E find(E target) {
        SLNode<E>[] update = search(target);
        if (update[0].links[0] != null
                && update[0].links[0].data.compareTo(target) == 0) {
            return update[0].links[0].data;
        } else {
            return null;
        }
    }

// Insert solution to programming exercise 1, section 6, chapter 9 here
    @SuppressWarnings({ "unchecked" })
	public void add(E item)
    {
        SLNode<E> x = head;
        SLNode<E>[] updated = new SLNode[maxLevel + 1];
        
        for (int i = size; i >= 0; i--) {
            while (x.links[i] != null && (x.links[i].data).compareTo(item) < 0) {
                x = x.links[i];
            }
            updated[i] = x; 
        }
        x = x.links[0];
        
        if (x == null || !x.data.equals(item)) {        
            int lvl = logRandom();
            
            //Update heads
            if (lvl > size) {
                for (int i = size + 1; i <= lvl; i++) {
                    updated[i] = head;
                }
                size = lvl -1;
            }
            
            //Insert new Node
            x = new SLNode<E>(lvl, item);
            for (int i = 0; i < lvl; i++) {
                x.links[i] = updated[i].links[i];
                updated[i].links[i] = x;
            }
        }
    }

    /**
     * Determine if an item is in the tree
     * @param target Item being sought in tree
     * @return true If the item is in the tree, false otherwise
     */
    public boolean contains(E target) {
        return find(target) != null;
    }

// Insert solution to programming exercise 2, section 6, chapter 9 here

    /**
     * Removes target from tree.
     * @post target is not in the tree
     * @param target Item to be removed
     * @return true if the object was in the tree, false otherwise
     */
    @SuppressWarnings("unchecked")
	public void remove(E target) {
    	
    		SLNode<E> x = head;
    		SLNode<E>[] update = new SLNode[maxLevel + 1];
    		
    		for(int i = size; i >=  0; i--)
    		{
    			while(x.links[i] != null && (x.links[i].data).compareTo(target) < 0)
    			{
    				x = x.links[i];
    			}
    			update[i] = x;
    		}
    		x = x.links[0];
    		
    		if(x.data.equals(target))
    		{
    			//Remove item from list
    			for(int i = 0; i <= size; i++)
    			{
    				if(update[i].links[i] != x)
    				{
    					break;	//Stop shifting
    				}
    				update[i].links[i] = x.links[i]; //Shift the current links to the new links
    			}
    			
    			//Decrease the size of the list
    			while(size > 0 && head.links[size] == null)
    			{
    				size--;
    			}
    		}
    }

	/** Remove all data from the tree */
    public void clear() {
        for (int i = 0; i < maxLevel; i++) {
            head.links[i] = null;
        }
        size = 0;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        SLNode<E> x = head.links[0];
        while (x != null) {
            sb.append(x.data);
            x = x.links[0];
            if (x != null)
                sb.append(",");
        }    
        sb.append("}");
        return sb.toString();
    }
}
/*</listing>*/
