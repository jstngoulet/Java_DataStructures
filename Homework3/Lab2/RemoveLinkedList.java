package Lab2;
import java.util.LinkedList;

public class RemoveLinkedList<E> {

	public LinkedList<E> list;
	
	public RemoveLinkedList() {
		// TODO Auto-generated constructor stub
	}
	
	//Should not be able to run
	public boolean remove(E item)
	{
		boolean found = false;
		
		for(int i = 0; i < list.size(); i++)
		{
			if(list.contains(item))
			{
				list.remove(item);
				found = true;
			}
		}
		
		return found;
	}

}
