package application;

import publisher.Publisher;

public class Main {
	
	public static void main(String[] args) throws Exception {
		publishers();
		Thread.sleep(3000);
		System.exit(0);
	}
	
	public static void publishers() throws Exception {
		Publisher publisher = new Publisher("p");
		publisher.connect();
		publisher.publish("smoke", "12");
		publisher.publish("fire", "5");
		publisher.publish("temperature", "30");
		publisher.disconnect();
	}

}
