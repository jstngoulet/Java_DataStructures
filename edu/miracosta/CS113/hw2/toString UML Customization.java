public String toString()			//Class for Person (.toString());
{
	return "" + 
	"Name:\t\t" + getName() + 
	"\nSS#:\t\t" + getSSNum() + 
	"\nAge:\t\t" + getAge().toString() + 
	"\nGender:\t" + getGender() + 
	"\nAddress:\t" + getAddress() + 
	"\nTelephone:\t" + getTelephone().toString();
}

public String toString()			//Class for Student (.toString());
{
	return "" + 
	"\nG.P.A.:\t" + getGPA() + 
	"\nMajor:\t" + getMajor() + 
	"\nYear Grad:\t" + getYearGrad();
}

public String toString()			//Class for Employee (.toString());
{
	return "" + 
	"\nDepartment:\t" + getDept().toString() + 
	"\nJob Title:\t" + getTitle().toString() + 
	"\nYear Hired\t" + getYearHired().toString();
}

public String toString()			//Class for HourlyEmployees (.toString());
{
	return "" + 
	"\nRate:\t\t" + getRate().toString() +
	"\nHours Worked\t" + getHoursWorked().toString() + 
	"\nUnion Dues:\t"  + getDues().toString();
}

public String toString()			//Class for SalaryEmployees(.toString());
{
	return "" + 
	"\nAnnual Salary:\t" + getSalary().toString();
}