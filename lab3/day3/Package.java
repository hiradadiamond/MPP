package lab3.day3;

public class Package {
	private String packageDesc;
	private double packageWeight;
	private String pacakgeSendToZone;

	public Package(String packageDesc, double packageWeight, String pacakgeSendToZone) {
		this.packageDesc = packageDesc;
		this.packageWeight = packageWeight;
		this.pacakgeSendToZone = pacakgeSendToZone;
	}

	public String getPackageDesc() {
		return packageDesc;
	}

	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}

	public double getPackageWeight() {
		return packageWeight;
	}

	public void setPackageWeight(double packageWeight) {
		this.packageWeight = packageWeight;
	}

	public String getPacakgeSendToZone() {
		return pacakgeSendToZone;
	}

	public void setPacakgeSendToZone(String pacakgeSendToZone) {
		this.pacakgeSendToZone = pacakgeSendToZone;
	}

}
