package lab3.day3;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
	List<IDeliveryChannel> dChannels;
	String serviceName;

	public void registerDeliveryChannel(ADeliveryChannel newChannel) {
		dChannels.add(newChannel);
	}

	PriceCalculator() {
		this.dChannels = new ArrayList<IDeliveryChannel>();
	}

	public double lowerPrice(Package p) {
		double minCost = Double.MAX_VALUE;
		for (IDeliveryChannel dChannel : dChannels) {
			double channelCost = dChannel.computePrice(p);
			if (minCost > channelCost) {
				minCost = dChannel.computePrice(p);
				this.serviceName = dChannel.getClass().getSimpleName();
			}
		}
		return minCost;
	}

	public void setCurrentDeliveryName(String currentDeliveryName) {
		this.serviceName = currentDeliveryName;
	}

	public String getServiceName() {
		return this.serviceName;
	}
	
	public double discountCheck(double minCost, String senderType) {
		switch (senderType) {
		case "Student":
			minCost = minCost * 0.1 + minCost;
			break;
		case "Senior":
			minCost = minCost * 0.15 + minCost;
			break;
		default:
			break;
		}
		return minCost;
	}

}
