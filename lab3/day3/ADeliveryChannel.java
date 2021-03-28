package lab3.day3;

public abstract class ADeliveryChannel implements IDeliveryChannel {
	private double rate;
	
	public abstract double computePrice(Package p);

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
}
