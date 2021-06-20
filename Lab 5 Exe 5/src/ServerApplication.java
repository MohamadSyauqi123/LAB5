import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerApplication {

	public static void main(String[] args) {
		
		
		// Server UDP socket runs at this port
		final int serverPort=50010;
		
		int bufferSize = 1010;
		
		System.out.println("Server-Side Application for UDP demo\n");
		
		try {
			
			// Create a new DatagramSocket to receive responses from the client
		    DatagramSocket serverSocket = new DatagramSocket(50010);
		    
		    // Create buffer to hold receiving data.
		    byte[] inData = new byte[bufferSize];
		    
		    // Create a UDP packet to store the client data using the buffer 
		    // for receiving data
		    DatagramPacket inputPacket = new DatagramPacket(inData,
		    		inData.length);
		    System.out.println("Ready to receive connection... ");
		    // Receive data from the client and store in inputPacket
		    serverSocket.receive(inputPacket);
		    
		    // Printing out the client sent data
		    String data = new String(inputPacket.getData());
		    // to count the word
		 	String wordCount = Integer.toString(wordcount(data));
		    System.out.println("Data from the client: " + data);
		    
		    // Creating corresponding buffer to send data
		    byte outDataBuffer[] = new byte[bufferSize];
		    
		    // Converting data to bytes and storing them in the sending buffer
		    outDataBuffer = wordCount.getBytes();
		    
		    // Get client's address
		    InetAddress senderAddress = inputPacket.getAddress();
		    int senderPort = inputPacket.getPort();
		    
		    // Creating a UDP packet 
		    DatagramPacket outPacket = new DatagramPacket(outDataBuffer,
		    		outDataBuffer.length, senderAddress,senderPort);
		    
		    serverSocket.send(outPacket);
		    
		    // Close the socket connection
		    serverSocket.close();
		      
		} catch (Exception ex) {
			
			System.out.println("Durian Tunggal... we got problem");
			ex.printStackTrace();
		}
		
		System.out.println("\nProgram at server-side ends");

	}

	static int wordcount(String string)  
	{  
        int count=0;  
    
          char ch[]= new char[string.length()];     
          for(int i=0;i<string.length();i++)  
          {  
              ch[i]= string.charAt(i);  
              if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                  count++;  
          }  
          return count;  
      }
}
