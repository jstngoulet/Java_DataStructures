package Homework8_Part1;

public class HeapDriver {

	public HeapDriver() {
		new HeapDriver();
	}
	
	public static void main(String[] args)
	{
		// This class will call classes MinHeap and MaxHeap, and show their outputs.
		//int numsToTest[] = {15, 10, 9, 8, 6, 3, 4, 2, 12};
		String numsToTest[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
		
		MinHeap<String> min = new MinHeap<String>(numsToTest.length);
		//MaxHeap<Integer> max = new MaxHeap<Integer>(numsToTest.length);
		
		int index = 0;
		while (index < numsToTest.length)
		{
			min.insert(numsToTest[index]);
			//max.insert(numsToTest[index]);
			index++;
		}
		
		min.print();
		
	}

}
