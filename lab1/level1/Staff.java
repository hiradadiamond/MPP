package lab1.level1;

public class Staff extends Person {
	private double salary;
	
	Staff(String name, String phone, int age, double salary){
		super(name,phone,age);
		this.salary = salary;
	}
	
	@Override
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	

}
