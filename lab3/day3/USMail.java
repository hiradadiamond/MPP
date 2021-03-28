package lab3.day3;

public class USMail extends ADeliveryChannel {
	private final double rate = 0.55;

	@Override
	public double computePrice(Package p) {
		double price = 0;
		double pWeight = p.getPackageWeight();
		if (pWeight < 3) {
			price = 1;
		} else {
			price = pWeight * this.rate;
		}
		return price;
	}

}
