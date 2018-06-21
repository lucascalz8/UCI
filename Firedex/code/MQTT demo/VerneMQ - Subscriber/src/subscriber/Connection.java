package subscriber;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import application.Global;

public class Connection {
	private String identifier;
	private MqttClient client;
	private int priority;
	private List<String> topics;
	
	public Connection(String baseIdentifier, int priority) throws MqttException {
		IdentifierGenerator identifierGenerator = IdentifierGenerator.getInstance();
		String clientIdentifier = identifierGenerator.generateIdentifier();
		this.identifier = baseIdentifier + "-" + clientIdentifier;
		this.client = new MqttClient(Global.BROKER, this.identifier);
		this.priority = priority;
		this.topics = new ArrayList<>();
		
		PriorityPortMapping priorityPortMapping = PriorityPortMapping.getInstance();
		int port = priorityPortMapping.getPort(priority);
		MqttConnectOptions options = new MqttConnectOptions();
		options.setSocketFactory( new CustomSocketFactory(port) );
		this.client.connect(options);
		this.client.setCallback( new MessageHandler() {
			@Override
			public void messageArrived(String topic, MqttMessage message) throws Exception {
				System.out.println( "Message: " + new String(message.getPayload()) ); 
			}
		});
	}
	
	public String getIdentifier() {
		return (identifier);
	}
	
	public int getPriority() {
		return (priority);
	}
	
	public boolean subscribe(String topic) throws MqttException {
		if ( this.topics.contains(topic) )
			return (false);
		
		this.client.subscribe(topic);
		this.topics.add(topic);
		
		return (true);
	}
	
}
