/**
 * 
 */
package miracosta.CS113.hw2;
import java.util.Scanner;

/**
 * @author Justin
 * @DateModified Feb 7, 2014
 */
public class ComputeAreaAndPerimeter {
public static Scanner in;
	/**
	 * @param args
	 * @param Shape = Shape
	 * @param Perimeter
	 * @param area
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape myShape;
		double perimeter, area;
		myShape = getShape();
		myShape.readShapeData();
		perimeter = myShape.computePerim();
		area = myShape.computeArea();
		displayResult(myShape, area, perimeter);
		System.exit(0);;
	}
	
	/**
	 * @return ShapeChosen
	 */
	public static Shape getShape()
	{
		in = new Scanner(System.in);
		System.out.println("Enter C for Circle");
		System.out.println("Enter R for Rectangle");
		System.out.println("Enter T for Right Triangle");
		System.out.println("Enter S for Square");
		System.out.println("Enter E for Equalateral Triangle");
		String figType = in.next();
		
		if((figType.startsWith("c")) || (figType.startsWith("C")))
		{
			return new Circle();
		}
		else if((figType.startsWith("r")) || (figType.startsWith("R")))
		{
			return new Rectangle();
		}
		else if((figType.startsWith("T")) || (figType.startsWith("t")))
		{
			return new RightTriangle();
		}
		else if((figType.startsWith("s")) || (figType.startsWith("S")))
		{
			return new Square();
		}
		else if((figType.startsWith("e")) || (figType.startsWith("E")))
		{
			return new Equalateral();
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * @param myShape
	 * @param area
	 * @param perim
	 */
	private static void displayResult(Shape myShape, double area, double perim)
	{
		System.out.println(myShape);
		System.out.printf("The area is %.2f%nThe Perimeter is %.2f%n", area, perim);
		in.close();
	}

}
