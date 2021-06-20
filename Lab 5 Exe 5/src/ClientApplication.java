import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientApplication {
	
	public static void main(String[] args) {
		
		// The server port to which the client socket is going to connect
		final int SERVERPORT = 50010;
		
		int bufferSize = 1010;
		
		System.out.println("Client-Side Application for UDP demo\n");
		
		try {
			
			
			// Create client socket
		    DatagramSocket clientSocket = new DatagramSocket();
		    
		    // Get the IP address of the server
		    InetAddress serverAddress = InetAddress.getByName("localhost");
		    
		    // Creating corresponding buffer to send data
		    byte outDataBuffer[] = new byte[bufferSize];
		    
		    // Converting data to bytes and storing them in the sending buffer
		    String sentence = "DISTRIBUTED APPLICATION DEVELOPMENT";
		    outDataBuffer = sentence.getBytes();
		    
		    // Creating a UDP packet 
		    DatagramPacket outPacket = new DatagramPacket(outDataBuffer,
		    		outDataBuffer.length, serverAddress, SERVERPORT);
		    
		    // Sending UDP packet to the server
		    System.out.println("Sending '" + sentence + "'. "
		    		+ "Size = " + outDataBuffer.length);
		    clientSocket.send(outPacket);
		    
		    // Create buffer to hold receiving data.
		    byte[] inData = new byte[bufferSize];
		    
		    // Create a UDP packet to store the client data using the buffer 
		    // for receiving data
		    DatagramPacket inputPacket = new DatagramPacket(inData,
		    		inData.length);
		    // Receive data from the client and store in inputPacket
		    clientSocket.receive(inputPacket);
		    
		    // Printing out the client sent data
		    String data = new String(inputPacket.getData());
		    
		    System.out.println("Word Counted from sentences = " + data + "word(s)");
		    // Closing the socket connection with the server
		    clientSocket.close();
		    
		} catch (Exception ex) {
			
			System.out.println("Durian Tunggal... we got problem");
			ex.printStackTrace();
		}
		
		System.out.println("\nProgram at client-side ends");

	}

}
