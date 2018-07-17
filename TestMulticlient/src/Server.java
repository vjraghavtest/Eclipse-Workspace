import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public final static int PORT = 5555;
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket=new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true){
			try {
				System.out.println("Waiting for client");
				socket=serverSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Client connected");
			ClientHandlerThread thread=new ClientHandlerThread(socket);
			thread.start();
		}
	}

}
