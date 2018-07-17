import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Server implements Runnable {
	Socket socket=null;
	BufferedReader reader=null,socketReader=null;;
	PrintWriter writer=null;
	String msg=null;
	Integer id=null;
	public ClientHandler(Socket socket) {
		this.socket=socket;
		id=socket.getPort();
	}
	
	public void run(){
		System.out.println("Thread started for client "+id);
		try {
			reader=new BufferedReader(new InputStreamReader(System.in));
			socketReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer=new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true){
			try{
				
				System.out.println("Waiting for response from Client");
				msg=socketReader.readLine();
				if(socket.isClosed() || msg==null){
					System.out.println("Client "+ id+" is disconnected");
					reader.close();
					writer.close();
					socketReader.close();
					sockets.remove(id);
					status();
					break;
				}
				System.out.println("Message from "+id+" is "+msg);
				System.out.println("Enter response for client "+id);
				msg=reader.readLine();
				writer.println(msg);
				writer.flush();
				System.out.println("Response sent to client");
			}catch(IOException e){
				System.out.println("Client "+id+" disconnected from server");
				sockets.remove(id);
				status();
				break;
			}
			
			try {
				writer.println(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
