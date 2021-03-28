package lab1.level1;

public abstract class Person {
	private String name;
	private String phone;
	private int age;
	
	Person(String name, String phone, int age){
		this.name = name;
		this.phone = phone;
		this.age = age;	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("Name: " + this.getName() + ", ");
		output.append("Age: " + this.getAge() + ", ");
		output.append("Phone: " + this.getPhone() + ", ");
		output.append("Salary: "+ this.getSalary());
		return output.toString();
	}
	
	public void addCourse(Course s) {}
	public abstract double getSalary();
    
}
