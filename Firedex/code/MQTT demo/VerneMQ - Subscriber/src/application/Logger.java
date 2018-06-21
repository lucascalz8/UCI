package application;

public class Logger {
	
	private Logger() { }
	
	synchronized public static void printMessage(String message) {
		System.out.println(message);
	}

}
