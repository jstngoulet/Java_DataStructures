/**
 * 
 */
package miracosta.CS113.hw2;
import java.util.Scanner;

/**
 * @author Justin
 *
 */
public class Square extends Shape{
private double width;
	/**
	 * 
	 */
	public Square() {
		// TODO Auto-generated constructor stub
		super("Square");
	}
	
	/**
	 * @param width
	 */
	public Square(double width)
	{
		super("Square");
		this.width = width;
	}
	
	/**
	 * @return width
	 */
	public double getWidth(){
		return width;
	}
	
	/**
	 * @return area
	 */
	@Override
	public double computeArea()
	{
		return width * width;
	}
	
	/**
	 * @return Perimeter
	 */
	@Override
	public double computePerim()
	{
;		return width * 4;
	}
	
	@Override
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the width of the Square: ");
		width = in.nextDouble();
		in.close();
	}
	
	@Override
	public String toString(){
		return super.toString() + ": Width is " + width;
	}
	
	
	

}
