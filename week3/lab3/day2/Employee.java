package week3.lab3.day2;

public class Employee implements Cloneable{
	private static int employeeID = 0;
	private String firstName;
	private String middleName;
	private String lastName;
	private String birthDate;
	private String ssn;
	private double salary;
	private Position position;
	
	Employee(){}
	
	Employee(String firstname, String middleName, String lastName, String birthDate, String ssn, double salary, Position position){
		this.employeeID = getEmployeeId();
		this.firstName = firstname;
		this.middleName = middleName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.ssn = ssn;
		this.salary = salary;
		this.position = position;
	}
	
	public static int generateID() {
		return employeeID++;
	}
	public static int getEmployeeId() {
		return Employee.employeeID;
	}

	public static void setEmployeeId(int employeeId) {
		Employee.employeeID = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}
	
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getSSN() {
		return ssn;
	}

	public void setSSN(String sSN) {
		ssn = sSN;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void print() {
		System.out.println(this);
	}
	

	@Override
	public String toString() {
		StringBuilder empInfo = new StringBuilder();
		empInfo.append("empInfo: "+ " ");
		empInfo.append("Name: ")
		.append(this.getFirstName() + " " + getMiddleName()+ " " + getLastName() + ", ")
		.append("Salary: ")
		.append(this.getSalary()+ " ");
		return empInfo.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Employee) super.clone();	
	}
	
}
