package aula1.aula1;

import java.net.* ;


/**
 * Basic TCP server... 
 *
 */
public class TcpServer {
    
    private static final int PORT = 9000;
	private static final int BUF_SIZE = 1024;

	public static void main(String[] args) throws Exception {
        
		// Use Discovery to announce the uri of this server, in the form of (tcp://hostname:port)
        Discovery discovery = new DiscoveryImpl();
        String uri = "tcp://" + InetAddress.getLocalHost().getHostName() + ":" + PORT;
        String service = "my-tcp-server";
        discovery.announce(service, uri);


        
		try(var ss = new ServerSocket( PORT )) {
			System.err.println("Accepting connections at: " + ss.getLocalSocketAddress() ) ;
            while( true ) {
                var cs = ss.accept() ;
                
                System.err.println("Accepted connection from client at: " + cs.getRemoteSocketAddress() ) ;
                
                int n;
                var buf = new byte[ BUF_SIZE];
                while( (n = cs.getInputStream().read(buf)) > 0)
                	System.out.write( buf, 0, n);
                
                System.err.println("Connection closed.") ;
            }        	
        }
    }
    
}
