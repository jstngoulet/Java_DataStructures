/**
 * 
 */
package miracosta.CS113.hw2;
import java.util.Scanner;

/**
 * @author Justin
 *
 */
public class Rectangle extends Shape{
private double width, height;

	/**
	 * 
	 */
	public Rectangle() {
		// TODO Auto-generated constructor stub
		super("Rectangle");
	}
	
	/**
	 * @param width
	 * @param height
	 */
	public Rectangle(double width, double height)
	{
		super("Rectangle");
		this.width = width;
		this.height = height;
	}
	
	/**
	 * @return Width
	 */
	public double getWidth(){
		return width;
	}
	
	/**
	 * @return Height
	 */
	public double getHeight()
	{
		return height;
	}
	
	/**
	 * @return Area
	 */
	@Override
	public double computeArea()
	{
		return height * width;
	}
	
	/**
	 * @return perimeter
	 */
	@Override
	public double computePerim()
	{
		return 2 * (height + width);
	}
	
	/**
	 * @param in
	 * @param width
	 * @param height
	 * Gets Shape Data
	 */
	@Override
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the width of the rectangle: ");
		width = in.nextDouble();
		
		System.out.println("Enter the height of the rectangle: ");
		height = in.nextDouble();
		in.close();
	}
	
	/**
	 * @return Information
	 */
	@Override
	public String toString(){
		return super.toString() + ": Height is " + height + ", Width is " + width;
	}
	
	
	

}
