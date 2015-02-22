package Lab1PartB;

public class DirectoryEntry {

	public String name, number;
	
	public DirectoryEntry(String name, String number) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.number = number;
	}
	
	public String getNumber()
	{
		return number;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setNumber(String number)
	{
		this.number = number;
	}

}
