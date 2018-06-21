package subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriorityPortMapping {
	private static PriorityPortMapping instance;
	
	private Map<Integer, Integer> priorityPortMapping;
	
	private PriorityPortMapping() {
		initialize();
	}
	
	public static PriorityPortMapping getInstance() {
		if ( instance == null )
			instance = new PriorityPortMapping();
		return (instance);
	}
	
	private void initialize() {
		priorityPortMapping = new HashMap<>();
		priorityPortMapping.put(1, 7000);
		priorityPortMapping.put(2, 7001);
		priorityPortMapping.put(3, 7002);
		priorityPortMapping.put(4, 7003);
	}
	
	public List<Integer> getPriorities() {
		List<Integer> priorities = new ArrayList<>();
		priorities.addAll( priorityPortMapping.keySet() );
		return (priorities);
	}
	
	public int getPort(int priority) {
		return ( priorityPortMapping.getOrDefault(priority, -1) );
	}

}
