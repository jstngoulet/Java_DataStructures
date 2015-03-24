/**
 * 
 */
package Programming_Project2;

/**
 * @author Justin
 * @param <T>
 *
 */
public class Term<T> implements Comparable<T> {

	/**
	 * This class is going to read in a coefficient and an exponent, 
	 * then add the two coefficients together if their exponents are the same
	 */
	public static int coefficient, exponent;
	
	public Term(int co, int exp) {
		// TODO Auto-generated constructor stub
		coefficient = co;
		exponent = exp;
	}
	
	public void setCoefficient(int co){
		coefficient = co;
	}

	public void setExponent(int exp)
	{
		exponent = exp;
	}
	
	public int getCoefficient()
	{
		return coefficient;
	}
	
	public int getExponent()
	{
		return exponent;
	}
	
	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString()
	{
		return coefficient + "x^" + exponent + " ";
	}

}
