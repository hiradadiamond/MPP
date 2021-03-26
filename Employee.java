package lab3.lab3;

public class Employee {
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
		StringBuilder empInfo = new StringBuilder();
		empInfo.append("Name: ")
		.append(this.getFirstName() + " " + getMiddleName()+ " " + getLastName() + ", ")
		.append("Salary: ")
		.append(this.getSalary()+ " ")
		.append(this.position.getTitle());
		System.out.println(empInfo.toString());
	}
	
	
}
