package lab3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Package> packages = new ArrayList<Package>();

		putText("Enter the number of Pacakges");
		int numberOfPacakges = getInt();
		putText("Sender Type: ");
		String senderType = getString();
		for (int i = 0; i < numberOfPacakges; i++) {

			putText(" Package Title: ");
			String packageDesc = getString();
			putText(" Package Weight: ");
			double weightInPounds = getDouble();
			putText("Package Delivery Zone: ");
			String packageZone = getString();
			packages.add(new Package(packageDesc, weightInPounds, packageZone));
			putText(packageDesc + " is preparing for delivery");
			System.out.println();

		}

		ADeliveryChannel UPS = new UPS();
		ADeliveryChannel FedEx = new FedEx();
		ADeliveryChannel USMail = new USMail();

		PriceCalculator priceCalculator = new PriceCalculator();

		priceCalculator.registerDeliveryChannel(USMail);
		priceCalculator.registerDeliveryChannel(FedEx);
		priceCalculator.registerDeliveryChannel(UPS);

		StringBuilder result = new StringBuilder();

		for (Package p : packages) {
			double minCost = priceCalculator.lowerPrice(p);
			minCost = priceCalculator.discountCheck(minCost, senderType);
			result.append(p.getPackageDesc());
			result.append(" ");
			result.append(minCost);
			result.append(" ");
			result.append(priceCalculator.getServiceName());
			result.append("\n");
		}
		System.out.println(result.toString());
	}

	// -------------------------------------------------------------
	public static void putText(String s) // writes string s to the screen
	{
		System.out.println(s);
	}

	// -------------------------------------------------------------
	public static String getString() throws IOException // reads a string from the keyboard input
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	// -------------------------------------------------------------
	public static char getChar() throws IOException // reads a character from the keyboard input
	{
		String s = getString();
		return s.charAt(0);
	}

	// -------------------------------------------------------------
	public static int getInt() throws IOException // reads an integers from the keyboard input
	{
		String s = getString();
		return Integer.parseInt(s);
	}

	// -------------------------------------------------------------
	public static double getDouble() throws IOException // reads an double from the keyboard input
	{
		String s = getString();
		return (Double.valueOf(s)).doubleValue();
	}

}
