package lab3.day3;

import java.util.HashMap;
import java.util.Map;

public class FedEx extends ADeliveryChannel {
	private double rate;

	public FedEx() {
		super();
	}

	@Override
	public double computePrice(Package p) {
		String currentZone = p.getPacakgeSendToZone();
		double noOfPounds = p.getPackageWeight();
		Map<String, Integer> zones = new HashMap<String, Integer>();
		String[] zone1 = { "IA", "MT", "OR", "CA" };
		String[] zone2 = { "TX", "UT" };
		String[] zone3 = { "FL", "MA", "OH" };
		for (String s : zone1) {
			zones.put(s, 1);
		}
		for (String s : zone2) {
			zones.put(s, 2);
		}
		for (String s : zone3) {
			zones.put(s, 3);
		}

		if (zones.containsKey(currentZone) && zones.get(currentZone) == 1) {
			this.rate = 0.35;
		} else if (zones.containsKey(currentZone) && zones.get(currentZone) == 2) {
			this.rate = 0.30;
		} else if (zones.containsKey(currentZone) && zones.get(currentZone) == 3) {
			this.rate = 0.55;
		} else {
			this.rate = 0.43;
		}
		return this.rate * noOfPounds;

	}

}
