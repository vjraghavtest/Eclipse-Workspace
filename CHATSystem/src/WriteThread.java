import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WriteThread extends Thread {
	Socket socket = null;
	BufferedReader reader = null;
	String msg = null;
	PrintWriter writer = null;

	WriteThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(socket.getOutputStream(),true);
			while(true){
				msg=reader.readLine();
				if(msg.equals("END"))
					break;
				writer.println(msg);
			}
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
