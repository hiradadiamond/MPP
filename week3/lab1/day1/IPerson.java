package week3.lab1.day1;

public interface IPerson {
	default void myDefault() {
		System.out.println("From Default Method");
	}
	
	static void myStatic() {
		System.out.println("From static methods");
	}
	
	public abstract void myabstract();
}
