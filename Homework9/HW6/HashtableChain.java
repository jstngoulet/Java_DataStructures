package HW6;

import java.awt.List;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Hash table implementation using chaining.
 *  @author Koffman and Wolfgang
 **/
public class HashtableChain<K, V> extends AbstractMap<K, V> {

	/** The table */
	private LinkedList<Entry<K, V>>[] table;
	/** The number of keys */
	private int numKeys;
	/** The capacity */
	private static final int CAPACITY = 101;
	/** The maximum load factor */
	private static double LOAD_THRESHOLD = 3.0;

	/** Contains key-value pairs for a hash table. */
	private static class Entry<K, V> implements Map.Entry<K, V> {

		/** The key */
		private K key;
		/** The value */
		private V value;

		/**
		 * Creates a new key-value pair.
		 * @param key The key
		 * @param value The value
		 */
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * Retrieves the key.
		 * @return The key
		 */
		@Override
		public K getKey() {
			return key;
		}

		/**
		 * Retrieves the value.
		 * @return The value
		 */
		@Override
		public V getValue() {
			return value;
		}

		/**
		 * Sets the value.
		 * @param val The new value
		 * @return The old value
		 */
		@Override
		public V setValue(V val) {
			V oldVal = value;
			value = val;
			return oldVal;
		}
		// Insert solution to programming exercise 3, section 4, chapter 7 here
		/**
		 * Return a string representaion of the entry
		 * @Return a Stirng Rep of the Entry
		 * 		In the form of Key = Value
		 */
		@Override
		public String toString()
		{
			return key.toString() + " = " + value.toString();
		}
	}

	// Constructor
	public HashtableChain() {
		table = new LinkedList[CAPACITY];
	}

	/*<listing chapter="7" number="9">*/
	/**
	 * Method get for class HashtableChain.
	 * @param key The key being sought
	 * @return The value associated with this key if found;
	 *         otherwise, null
	 */
	@Override
	public V get(Object key) {
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index += table.length;
		}
		if (table[index] == null) {
			return null; // key is not in the table.
		}
		// Search the list at table[index] to find the key.
		for (Entry<K, V> nextItem : table[index]) {
			if (nextItem.key.equals(key)) {
				return nextItem.value;
			}
		}

		// assert: key is not in the table.
		return null;
	}
	/*</listing>*/

	/*<listing chapter="7" number="10">*/
	/**
	 * Method put for class HashtableChain.
	 * @post This key-value pair is inserted in the
	 *       table and numKeys is incremented. If the key is already
	 *       in the table, its value is changed to the argument
	 *       value and numKeys is not changed.
	 * @param key The key of item being inserted
	 * @param value The value for this key
	 * @return The old value associated with this key if
	 *         found; otherwise, null
	 */
	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index += table.length;
		}
		if (table[index] == null) {
			// Create a new linked list at table[index].
			table[index] = new LinkedList<Entry<K, V>>();
		}

		// Search the list at table[index] to find the key.
		for (Entry<K, V> nextItem : table[index]) {
			// If the search is successful, replace the old value.
			if (nextItem.key.equals(key)) {
				// Replace value for this key.
				V oldVal = nextItem.value;
				nextItem.setValue(value);
				return oldVal;
			}
		}

		// assert: key is not in the table, add new item.
		table[index].addFirst(new Entry<K, V>(key, value));
		numKeys++;
		if (numKeys > (LOAD_THRESHOLD * table.length)) {
			rehash();
		}
		return null;
	}
	
	private void rehash()
	{
		//Increase the load capacity by x2, then rehash all table contents
		LOAD_THRESHOLD *= 2;
		
		LinkedList[] temp = new LinkedList[CAPACITY * 2];
		for(int i = 0; i < table.length; i++)
		{
			//No Idea How to rehash my table[index]
		}
		
	}
	/*</listing>*/

	// Insert solution to programming exercise 4, section 4, chapter 7 here
	@Override
	public String toString()
	{
		String tableStr = "", entry = "";
		//Loop through the entire table
		for(LinkedList<Entry<K, V>> tempKey : table)
		{
			for(int i = 0; i < tempKey.size(); i++)
			{
				entry += tempKey.get(i).toString();
			}
			tableStr += entry + "\n";
		}
		return tableStr;
	}

	// Insert solution to programming exercise 5, section 4, chapter 7 here
	/**
	 * @return number of Entries
	 */
	public int size()
	{
		return numKeys;
	}

	/** Returns true if empty */
	public boolean isEmpty() {
		return numKeys == 0;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class EntrySet extends AbstractSet<Map.Entry<K, V>>
	{

		@Override
		public Iterator<java.util.Map.Entry<K, V>> iterator() {
			// TODO Auto-generated method stub
			return new SetIterator();
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return numKeys;
		}
		
	}
	
	private class SetIterator implements Iterator<Map.Entry<K, V>>{

		int index = 0;
		Iterator<Entry<K, V>> localIterator = null;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(localIterator != null)
			{
				if(localIterator.hasNext())
				{
					return true;
				}
				else{
					localIterator = null;
					index++;
				}
			}
			while(index < table.length && table[index] == null)
			{
				index++;
			}
			if(index == table.length)
				return false;
			localIterator = table[index].iterator();
			return localIterator.hasNext();
		}

		@Override
		public java.util.Map.Entry<K, V> next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	// Insert solution to programming exercise 2, section 4, chapter 7 here
	/**Remove Method*/
	public V remove(Object key){
		int index = key.hashCode() % table.length;
		int counter = 0;
		
		if(index < 0)
			index += table.length;
		if(table[index] == null)
			return null;
		
		//Find the key in the table
		String tempKey = "";
		while(!tempKey.equals(key.toString()) && counter < table.length)
		{
			tempKey = table[index].toString();
			index++;
			index = table.length % index;
			counter++;
		}
		if(counter >= table.length)
			return null;
		else{
			//Remove the found item
			table[index].remove();
			numKeys--;
			
			if(table[index].isEmpty())
				table[index] = null;
			
			return table[index].getFirst().getValue();
		}
	}


	// Insert solution to programming project 7, chapter -1 here
}
