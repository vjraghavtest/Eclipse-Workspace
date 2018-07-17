import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public final static int PORT = 5555;
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		WriteThread writer=null;
		ReadThread reader=null;
		
		try {
			// creating server socket
			serverSocket = new ServerSocket(PORT);

			// listen on port until request
			socket = serverSocket.accept();
			// connection established
		} catch (Exception e) {
			System.out.println("Exception while establishing connection");
			 e.printStackTrace();
		}
		System.out.println("Socket "+socket.toString());
//		socket.toString()
		try {
			// receiving req msg from cient
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
