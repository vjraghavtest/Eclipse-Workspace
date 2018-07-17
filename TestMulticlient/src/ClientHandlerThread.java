import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandlerThread extends Thread {
	Socket socket=null;
	BufferedReader reader = null;
	String msg = null;
	public ClientHandlerThread(Socket socket) {
		this.socket=socket;
	}

	public void run() {
		try {
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true){
			try {
				System.out.println("reading client message");
				msg = reader.readLine();
				System.out.println("Message read");
				System.out.println(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (msg.equals("END"))
				break;
		}
	}

}
