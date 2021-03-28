package lab3.day3;

public class UPS extends ADeliveryChannel {
	private final double rate = 0.45;

	@Override
	public double computePrice(Package p) {
		double pWeight = p.getPackageWeight();
		double price = rate * pWeight;
		return price;
	}

}
