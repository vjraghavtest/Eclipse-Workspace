import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
//	volatile static 
	public static void main(String[] args) {

		InetAddress address = null;
		Socket socket = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader socketReader = null;
		PrintWriter writer = null;
		String msg = null;

		try {
			address = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			System.out.println("Host not found");
		}

		try {
			// create socket
			socket = new Socket(address, 5555);
			writer = new PrintWriter(socket.getOutputStream(), true);
			socketReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.out.println("Server not running");
			System.exit(0);
		}
		try {
			// request message sending
			System.out.println("Enter message to send(END disconnects from server):-\n");
			while(true) {
				System.out.println("Reading from in stream");
				msg = reader.readLine();
				if(msg.equals("END"))
					break;
				System.out.println("Writing to socket out stream");
				writer.println(msg);
				writer.flush();
				System.out.println("Reading from socket in stream");
				msg=socketReader.readLine();
				System.out.println(msg);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// closing connection
		try {
			socket.close();
			reader.close();
			writer.close();
			System.out.println("Connection closed");
		} catch (IOException e) {
			System.out.println("Error while closing connection");
		}
	}

}
