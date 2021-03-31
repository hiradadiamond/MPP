package lab5;

import java.time.LocalDate;

public class Order {
	private static int orderNo = 100;
	private LocalDate orderDate;
	private double orderAmount;
	public Order( double orderAmount, LocalDate orderDate) {
	
		Order.orderNo = orderNo++;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	

}
