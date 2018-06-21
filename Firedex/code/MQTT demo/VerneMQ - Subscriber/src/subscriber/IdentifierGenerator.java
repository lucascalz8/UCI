package subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IdentifierGenerator {
	private static IdentifierGenerator instance;
	
	private static final int LENGTH = 6;
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
	private Random random;
	private List<String> identifiers;

	private IdentifierGenerator() { 
		random = new Random();
		this.identifiers = new ArrayList<>();
	}
	
	static public IdentifierGenerator getInstance() {
		if ( instance == null )
			instance = new IdentifierGenerator();
		return (instance);
	}
	
	public String generateIdentifier() {
		String identifier = "";
		
		do {
			identifier = "";
			for (int i = 0; i < LENGTH; i++) {
				int index = random.nextInt( CHARACTERS.length() );
				char character = CHARACTERS.charAt(index);
				identifier = identifier + character;
			}
		} while ( identifiers.contains(identifier) );
		
		identifiers.add(identifier);
		return (identifier);
	}
	
}
