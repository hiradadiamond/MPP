package week3level4;

public enum DeliveryChannel {
	UPS(3),
	FedEx(21);
	
	private int days;
	DeliveryChannel(int days){
		this.days= days;
	}
	
	public double calculatePrice(double weight, double rate) {
		return weight* rate;
	}
}
