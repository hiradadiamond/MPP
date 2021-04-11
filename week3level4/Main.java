package week3level4;

import java.util.zip.InflaterInputStream;

public class Main {

	public static void main(String[] args) {
		System.out.println("Enter packages-weight");
		double priceForDeliveryUsingUPS =  DeliveryChannel.UPS.calculatePrice(3, 0.55);
		String formatPrice = String.format("$%,.2f", priceForDeliveryUsingUPS);
		System.out.print("Price for delivery:" + formatPrice);
		
		int[] arr = {1,2,3};
	}

}
