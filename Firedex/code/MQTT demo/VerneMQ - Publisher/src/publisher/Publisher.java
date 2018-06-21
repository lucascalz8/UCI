package publisher;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import application.Global;
import application.Logger;
import communication.Message;

public class Publisher {
	private String identifier;
	private MqttClient client;
	
	public Publisher(String identifier) throws MqttException {
		this.identifier = identifier;
		this.client = new MqttClient(Global.BROKER, identifier);
		Logger.printMessage( String.format("Created publisher (id: %s).", identifier) );
	}
	
	public String getIdentifier() {
		return (identifier);
	}
	
	public void connect() throws MqttException {
		client.connect();
		Logger.printMessage( String.format("Publisher connected (id: %s).", identifier) );
	}
	
	public void publish(String topic, String content) throws MqttException {
		Logger.printMessage( String.format("Publisher publishing message (id: %s, topic: %s, message: %s).", identifier, topic, content) );
		byte[] contentBytes = content.getBytes();
		client.publish( topic, new MqttMessage(contentBytes) );
	}
	
	public void publish(Message message) throws MqttException {
		publish( message.getTopic(), message.getContent() );
	}
	
	public void disconnect() throws MqttException {
		client.disconnect();
		Logger.printMessage( String.format("Publisher disconnected (id: %s).", identifier) );
	}

}
