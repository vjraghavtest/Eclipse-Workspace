import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashMap;

public class Server {
	public final static int PORT = 5555;
	static LinkedHashMap<Integer, Socket> sockets = null;
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		sockets = new LinkedHashMap<Integer, Socket>();
		
		try {
			serverSocket=new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true){
			try {
				System.out.println("Choice-\n1.Response\n2.Disconnect");
				new Thread(new ResponseHandler()).start();
				System.out.println("Waiting for client");
				socket=serverSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Client connected");
			sockets.put(socket.getPort(), socket);
			System.out.println("Client socket added to list");
			ClientHandler clientHandler=new ClientHandler(socket);
			Thread thread=new Thread(clientHandler);
			thread.start();
			System.out.println("Thread for client "+socket.getPort()+" is created"+thread.getName());
		}
	}
	
	public static int status(){
		int client=sockets.keySet().size();
		System.out.println("No. of Connected clients is "+client);
		return client;
	}
}
