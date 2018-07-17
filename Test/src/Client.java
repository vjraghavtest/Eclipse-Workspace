import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static Socket socket = null;
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		InetAddress address = null;
		
		

		try {
			address = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			System.out.println("Host not found");
		}
		
		try {
			// create socket
			socket = new Socket();
			socket.connect(new InetSocketAddress(address, 5555),100);
//			socket.setSoTimeout(100);
			System.out.println(socket.getSoTimeout());
		} catch (IOException e) {
			System.out.println("Server not running");
			System.exit(0);
		}
		try {
			new DataOutputStream((socket.getOutputStream())).writeUTF("hi");
			new Scanner(System.in).nextLine();
			new DataOutputStream((socket.getOutputStream())).writeUTF("hi");
			new DataOutputStream((socket.getOutputStream())).writeUTF("hi");
//			BufferedOutputStream outputStrem=new BufferedOutputStream(socket.getOutputStream());
//			System.out.println("Writing");
//			outputStrem.write(1);
//			outputStrem.flush();
//			System.out.println("writted");
//			
//			BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			System.out.println("reading");
//			System.out.println(reader.read());
//			System.out.println("readed");
			
			
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
