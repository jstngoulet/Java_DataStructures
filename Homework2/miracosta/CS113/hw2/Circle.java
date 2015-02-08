/**
 * 
 */
package miracosta.CS113.hw2;
import java.util.Scanner;

/**
 * @author Justin
 *
 */
public class Circle extends Shape{
private double diameter;
	public Circle() {
		// TODO Auto-generated constructor stub
		super("Circle");
	}
	
	/**
	 * @param diameter
	 * @param height
	 */
	public Circle(double diameter, double height)
	{
		super("Circle");
		this.diameter = diameter;
	}
	
	/**
	 * @return
	 */
	public double getdiameter(){
		return diameter;
	}
	
	/**
	 * @return Area
	 */
	@Override
	public double computeArea()
	{
		double rad = diameter/2;
		double radSq = rad * rad;
		return radSq * 3.14;
	}
	
	/**
	 * @return Perimeter
	 */
	@Override
	public double computePerim()
	{
		return 3.14 * diameter;
	}
	
	/**
	 * @param in
	 * @param diameter
	 */
	@Override
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the diameter of the Circle: ");
		diameter = in.nextDouble();
		in.close();
	}
	
	/**
	 * Show the results
	 */
	@Override
	public String toString(){
		return super.toString() + ": Diameter is " + diameter;
	}
	
	
	

}
