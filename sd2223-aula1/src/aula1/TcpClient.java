package aula1.aula1;

import java.net.* ;
import java.util.*;

/**
 * Basic TCP client... 
 *
 */
public class TcpClient {
    
	private static final String QUIT = "!quit";

	public static void main(String[] args) throws Exception {

		Discovery discovery = new DiscoveryImpl();

		URI[] uri = Udiscovery.knownUrisOf("my-tcp-server", 10);
		if (uris.length == 0) {
        System.out.println("No server found for myservice");
        return;
   		 }

    	URI uri = uris[0];
    	var hostname = uri.getHost();
    	var port = uri.getPort();
    	

    	try( var cs = new Socket( hostname, port); var sc = new Scanner(System.in)) {
    		String input;
    		do {
    			input = sc.nextLine();
    			cs.getOutputStream().write( (input + System.lineSeparator()).getBytes() );
    		} while( ! input.equals(QUIT));
    		
    	}
    }  
}
