import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		InetAddress address = null;
		Socket socket = null;
		WriteThread writer=null;
		ReadThread reader=null;
		
		try {
			address = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			System.out.println("Host not found");
		}
		
		try {
			// create socket
			socket = new Socket(address, Server.PORT);
		} catch (IOException e) {
			System.out.println("Server not running");
			System.exit(0);
		}
		
		try{
			System.out.println("Connection established");
			writer=new WriteThread(socket);
			reader=new ReadThread(socket);
			
			writer.start();
			reader.start();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			while(true){
				if(!writer.isAlive() || !reader.isAlive()){
					socket.close();
					System.out.println("Connection closed");
					break;
				}
			}
		}catch(Exception e){
			System.out.println("Exception on socket closing");
		}
	}

}
