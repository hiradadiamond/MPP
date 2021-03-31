package lab5;

public class Salaried extends Employee {
	private double salary;

	public Salaried(double salary) {
		super();
		this.salary = salary;
	}

	@Override
	public double calcGrossPay(DateRange d) {
		return this.getSalary();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
