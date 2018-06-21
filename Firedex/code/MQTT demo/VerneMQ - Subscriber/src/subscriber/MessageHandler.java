package subscriber;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public abstract class MessageHandler implements MqttCallback {

	@Override
	public void connectionLost(Throwable cause) { }

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) { }

	@Override
	public abstract void messageArrived(String topic, MqttMessage message) throws Exception;

}
