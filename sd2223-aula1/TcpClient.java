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
        
    	// Use Discovery to obtain the hostname and port of the server;
		URI[] uri = null;
		while ((uri = Discovery.getInstance().knownUrisOf("solicitar", 0)) == null);

		var port = uri[0].getPort();
    	var hostname = uri[0].getHost();
		System.out.println("going to connect to:" +hostname+ "/" + port);
    	try( var cs = new Socket(hostname, port); var sc = new Scanner(System.in)) {
    		String input;
    		do {
    			input = sc.nextLine();
    			cs.getOutputStream().write( (input + System.lineSeparator()).getBytes() );
    		} while( ! input.equals(QUIT));
    		
    	}
    }  
}