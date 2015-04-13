package Homework8_Part1;

import java.util.Comparator;

public class MaxHeap<E> extends Heap<E>{

	public MaxHeap(int size) {
		this(size, null);
		// TODO Auto-generated constructor stub
	}
	
	public MaxHeap(int size, Comparator<E> compare)
	{
		super(size, compare);
	}

	@Override
	void insert(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	Object extract() {
		// TODO Auto-generated method stub
		return null;
	}

}
