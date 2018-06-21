package subscriber;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class Subscriber {
	private String identifier;
	private List<Connection> connections;
	
	public Subscriber(String identifier) throws MqttException {
		this.identifier = identifier;
		this.connections = new ArrayList<>();
	}
	
	public String getIdentifier() {
		return (identifier);
	}
	
	public boolean subscribe(String topic, int priority) throws MqttSecurityException, MqttException {
		for ( Connection connection : connections )
			if ( connection.getPriority() == priority )
				return ( connection.subscribe(topic) );
		
		Connection connection = new Connection( getIdentifier(), priority );
		connections.add(connection);
		connection.subscribe(topic);
		return (true);
	}

}
