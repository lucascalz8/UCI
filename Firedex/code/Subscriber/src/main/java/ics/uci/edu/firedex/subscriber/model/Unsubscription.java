package ics.uci.edu.firedex.subscriber.model;

public class Unsubscription {
	private String topic;
	private int priority;
	
	public Unsubscription(String topic, int priority) {
		this.topic = topic;
		this.priority = priority;
	}
	
	public String getTopic() {
		return (topic);
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public int getPriority() {
		return (priority);
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}

}
