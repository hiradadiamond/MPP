package lab5;

public class Hourly extends Employee {
	private double hourlyWage;
	private double hoursPerWeek;
	
	
	public Hourly(double hourlyWage, double hoursPerWeek) {
		super();
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}


	@Override
	public double calcGrossPay(DateRange d) {
		return 4*(this.hourlyWage * this.hoursPerWeek);
	}


	public double getHourlyWage() {
		return hourlyWage;
	}


	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}


	public double getHoursPerWeek() {
		return hoursPerWeek;
	}


	public void setHoursPerWeek(double hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	

}
