package Programming_Project3;

public class Student {

	private static String firstName;
	
	public Student(String first) {
		// TODO Auto-generated constructor stub
		setFirstName(first);
	}

	public static String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		Student.firstName = firstName;
	}
	
	@Override
	public String toString()
	{
		return firstName.substring(0, 1).toUpperCase() + firstName.substring(1, firstName.length()).toLowerCase();
	}

}
