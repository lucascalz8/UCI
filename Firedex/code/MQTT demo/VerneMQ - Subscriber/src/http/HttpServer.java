package http;

import java.util.Random;

import fi.iki.elonen.NanoHTTPD;

public class HttpServer extends NanoHTTPD {
	private Random random = new Random();
	
	public HttpServer(int port) {
		super(port);
	}
	
	@Override
	public Response serve(IHTTPSession session) {
		String resource = session.getUri();
		if ( resource.equals("/") ) {
			return ( newFixedLengthResponse("<h1>Ciaooo</h1") );
		} else if ( resource.equals("show") ) {
			int n = random.nextInt();
			return ( newFixedLengthResponse("<h1>" + n + "</h1") );
		}
		return ( newFixedLengthResponse("<h1>Not found.</h1>") );
	}

}
