package lab5;

import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee {
	private double commission;
	private double baseSalary;
	private List<Order> orders;
	public Commissioned( double baseSalary) {
		super();
		this.commission = 0.07;
		this.baseSalary = baseSalary;
		this.orders = new ArrayList<Order>();
	}
	
	public void addOrders(Order o) {
		this.orders.add(o);
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public double calcGrossPay(DateRange d) {
		double orderAmountTotal = 0;
		if(this.orders == null) return baseSalary;
		double totalGrossPay = 0;
		for(Order o : orders) {
			if(d.isInRange(o.getOrderDate()))
				orderAmountTotal += o.getOrderAmount();		
		}
		totalGrossPay = baseSalary + (orderAmountTotal * (commission));
		return totalGrossPay;
	}
	
	
	
}
