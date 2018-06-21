package application;

import http.HttpServer;
import subscriber.Subscriber;

public class Main {
	
	public static void main(String[] args) throws Exception {
		subscriber();
		(new HttpServer(8080)).start();
		Thread.sleep(60000);
		System.exit(0);
	}
	
	public static void subscriber() throws Exception {
		Subscriber subscriber = new Subscriber("s");
		subscriber.subscribe("smoke", 2);
		subscriber.subscribe("fire", 1);
		subscriber.subscribe("temperature", 2);
	}

}
