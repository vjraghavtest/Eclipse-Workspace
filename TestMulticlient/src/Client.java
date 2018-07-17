import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {

		InetAddress address = null;
		Socket socket = null;
		BufferedReader reader = null,consoleReader=null;;
		PrintWriter writer = null;
		String msg = null;

		try {
			address = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			System.out.println("Host not found");
		}
		
		try {
			socket=new Socket("127.0.0.1", 5555);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			consoleReader=new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(socket.getOutputStream(),true);
			while(true){
				msg=consoleReader.readLine();
				if(msg.equals("END"))
					break;
				writer.println(msg);
				System.out.println("Mag sent to server");
				System.out.println("Waiting for response from server");
				msg=reader.readLine();
				System.out.println("Server Response is "+msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
