package lab5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Employee {
	private static int idCounter = 0;
	private int empId;
	private List<PayCheck> paychecks;

	public Employee() {
		this.empId = idCounter++;
		paychecks = new ArrayList<PayCheck>();
	}

	public void addPayCheck(PayCheck p) {
		paychecks.add(p);
	}

	public int getEmpId() {
		return this.empId;
	}

	public void print() {
		
		System.out.print("Employee Id : " + this.empId);

	}

	public PayCheck calcCompensation(int aMonth, int aYear) {
		LocalDate date = LocalDate.of(aYear, aMonth, 1);
		LocalDate startDate = date.minusDays(date.getDayOfMonth() - 1);
		LocalDate endDate = date.minusDays(date.getDayOfMonth()).plusMonths(1);
		DateRange dateRange = new DateRange(startDate, endDate);
		double grossPay = this.calcGrossPay(dateRange);
		PayCheck payCheckForEmp = new PayCheck(grossPay, dateRange, this);
		addPayCheck(payCheckForEmp);
		return payCheckForEmp;
	}

	public abstract double calcGrossPay(DateRange d);

	public List<PayCheck> getPaychecks() {
		return paychecks;
	}

	public void setPaychecks(List<PayCheck> paychecks) {
		this.paychecks = paychecks;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	

}
