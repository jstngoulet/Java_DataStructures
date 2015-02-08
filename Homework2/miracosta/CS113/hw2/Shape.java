/**
 * 
 */
package miracosta.CS113.hw2;
/**
 * @author Justin
 *
 */
abstract class Shape {

	private String shapeName = "";
	
	/**
	 * @param shapeName
	 */
	public Shape(String shapeName)
	{
		this.shapeName = shapeName;
	}
	/**
	 * @return shapeName
	 */
	public String getShapeName()
	{
		return shapeName;
	}
	
	/**
	 * @return shapeName
	 */
	@Override
	public String toString()
	{
		return "Shape is a " + shapeName;
	}
	
	//Abstract methods
	public abstract double computeArea();
	public abstract double computePerim();
	public abstract void readShapeData();
	

}
