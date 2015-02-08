/**
 * 
 */
package miracosta.CS113.hw2;
import java.util.Scanner;

/**
 * @author Justin
 *
 */
public class RightTriangle extends Shape{
private double width, height;
	/**
	 * 
	 */
	public RightTriangle() {
		// TODO Auto-generated constructor stub
		super("RightTriangle");
	}
	
	/**
	 * @param width
	 * @param height
	 */
	public RightTriangle(double width, double height)
	{
		super("RightTriangle");
		this.width = width;
		this.height = height;
	}
	
	/**
	 * @return width
	 */
	public double getWidth(){
		return width;
	}
	
	/**
	 * @return height
	 */
	public double getHeight()
	{
		return height;
	}
	
	/**
	 * @return area
	 */
	@Override
	public double computeArea()
	{
		return (height * width)/2;
	}
	
	/**
	 * @return perimeter
	 */
	@Override
	public double computePerim()
	{
		double cSquared = (height * height) + (width * width);
		double c = Math.sqrt(cSquared)
;		return height + width + c;
	}
	
	/**
	 * Reads in data for Shape
	 */
	@Override
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the width of the RightTriangle: ");
		width = in.nextDouble();
		
		System.out.println("Enter the height of the RightTriangle: ");
		height = in.nextDouble();
		in.close();
	}
	
	/**
	 * Displays information
	 */
	@Override
	public String toString(){
		return super.toString() + ": Height is " + height + ", Width is " + width;
	}
	
	
	

}
