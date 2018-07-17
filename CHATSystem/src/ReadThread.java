import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread {
	Socket socket = null;
	BufferedReader reader = null;
	String msg = null;

	ReadThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (socket.isConnected()) {
				try {
					msg = reader.readLine();
				} catch (Exception e) {
//					e.printStackTrace();
				}
				if(msg.equals("END"))
					break;
				System.out.println("Message:-" + msg);

			} 
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
