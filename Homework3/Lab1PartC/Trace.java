package Lab1PartC;

public class Trace {

	/**
	 * 
	 * Wrong One!!! Ignore :)
	 * 
	 * 
	 */
	
	public Trace() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] anArray = {0, 1, 2, 3, 4, 5, 6, 7};
		
		for(int i = 3; i < anArray.length - 1; i++)
		{
			anArray[i+1] = anArray[i];
			System.out.println(anArray[i + 1]);
		}
		
		int aSecArray[] = {0, 1, 2, 3, 4, 5, 6, 7};

		for(int i = aSecArray.length - 1; i > 3; i--)
		{
			anArray[i] = anArray[i-1];
			System.out.println(anArray[i]);
		}
	}
	//All of the contents are equivilent to the number: '3';

}
