package lab5;

public final class PayCheck {
	private double grossPay;
	private double fica;
	private double state;
	private double local;
	private double medicare;
	private double socialSecurity;
	private DateRange payPeriod;
	private Employee emp;

	public PayCheck(double grossPay, DateRange payPeriod, Employee e) {
		this.grossPay = grossPay;
		this.fica = 0.23;
		this.state = 0.05;
		this.local = 0.01;
		this.medicare = 0.03;
		this.socialSecurity = 0.075;
		this.payPeriod = payPeriod;
		this.emp = e;
	}

	public void print() {
		double totalPayCheck = this.getNPay();
		emp.print();
		System.out.printf(" PayCheck Amount is $%,.2f  ", totalPayCheck);
		System.out.println(" Pay Period: "+ payPeriod);
	}

	public double getNPay() {
		double totalDeduction = 0;
		totalDeduction +=  (this.fica * grossPay + this.state * grossPay + this.local * grossPay
				+ this.medicare * grossPay + this.socialSecurity * grossPay);
		return grossPay - totalDeduction;

	}

	@Override
	public String toString() {
		return "grossPay " + grossPay + "PayCheck Amount: "
				+ ", medicare=" + medicare + ", socialSecurity=" + socialSecurity + ", payPeriod=" + payPeriod + "]";
	}

}
