import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public final static int PORT = 5555;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader socketReader = null;
		PrintWriter writer = null;
		String msg = null;

		try {
			// creating server socket
			serverSocket = new ServerSocket(PORT);

			// listen on port until request
			socket = serverSocket.accept();
			// connection established
		} catch (Exception e) {
			System.out.println("Exception while establishing connection");
			// e.printStackTrace();
		}

		try {
			// receiving req msg from cient
			System.out.println("Connection established");
			socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);

			System.out.println("Message:-\n");
			do {
				msg = socketReader.readLine();
				if (msg.equals("END"))
					break;
				System.out.println(msg);
				msg = reader.readLine();
				writer.println(msg);
			} while (!msg.equals("END"));
			System.out.println("Message received");
		} catch (IOException ioe) {
			System.out.println("Exception on I/O");
		}

		// closing connection
		try {
			reader.close();
			socket.close();
			System.out.println("Connection closed");
		} catch (Exception e) {
			System.out.println("Exception on socket closing");
		}

	}
}
