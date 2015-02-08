/**
 * 
 */
package miracosta.CS113.hw2;
import java.util.Scanner;

/**
 * @author Justin
 *
 */
public class Equalateral extends Shape{
private double side;
	/**
	 * 
	 */
	/**
	 * 
	 */
	public Equalateral() {
		// TODO Auto-generated constructor stub
		super("Equalateral");
	}
	
	/**
	 * @param side
	 * @param height
	 */
	public Equalateral(double side, double height)
	{
		super("Equalateral");
		this.side = side;
	}
	
	/**
	 * @return side
	 */
	public double getside(){
		return side;
	}
	
	/**
	 * @return area
	 */
	@Override
	public double computeArea()
	{
		double sideSq = side * side;
		double rootThree = Math.sqrt(3);
		
		return (sideSq * rootThree)/4;
	}
	
	/**
	 * @return perimeter
	 */
	@Override
	public double computePerim()
	{
		return side * 3;
	}
	
	@Override
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the side of the Equalateral: ");
		side = in.nextDouble();
		in.close();
	}
	
	@Override
	public String toString(){
		return super.toString() + ": Side is " + side;
	}
	
	
	

}
