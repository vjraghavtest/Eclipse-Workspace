import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ResponseHandler extends Server implements Runnable {

	BufferedReader reader = null;
	Socket socket=null;
	PrintWriter writer=null;

	public void run() {
		while (true) {
			reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				System.out.println("Enter choice");
				switch (Integer.parseInt(reader.readLine())) {
				case 1:
					System.out.println("Client Id:-");
					for (Integer id : sockets.keySet()) {
						System.out.println(id);
					}
					try {
						System.out.println("Enter id");
						socket=sockets.get(Integer.parseInt(reader.readLine()));
						writer=new PrintWriter(socket.getOutputStream());
						System.out.println("Enter response to send");
						writer.println(reader.readLine());
						writer.flush();
						System.out.println("Data sent");
					} catch (Exception e) {
						System.out.println("Invalid id");
					}
					break;
				case 2:
					System.out.println("Client Id:-");
					for (Integer id : sockets.keySet()) {
						System.out.println(id);
					}
					try {
						System.out.println("Enter id");
						socket=sockets.get(Integer.parseInt(reader.readLine()));
						writer=new PrintWriter(socket.getOutputStream());
						writer.println("END");
						writer.flush();
						System.out.println("Data sent");
					} catch (Exception e) {
						System.out.println("Invalid id");
					}
					break;
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
