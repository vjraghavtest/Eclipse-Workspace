import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	static Socket socket = null;
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		final int PORT = 5555;
		
		ServerSocket serverSocket = null;
		
		
		try {
			serverSocket = new ServerSocket(PORT);
			
			while(true){
				socket = serverSocket.accept();
				System.out.println("Client connected");
				System.out.println(socket.getSoTimeout());
				System.out.println(socket.toString());
				System.out.println(new DataInputStream(socket.getInputStream()).readUTF());
				new Scanner(System.in).nextLine();
				System.out.println(socket.getInetAddress().isReachable(1000));
				System.out.println(new DataInputStream(socket.getInputStream()).readUTF());
				
				System.out.println(new DataInputStream(socket.getInputStream()).readUTF());
//				System.out.println("reading");
//				System.out.println((new BufferedInputStream(socket.getInputStream())).read());
//				System.out.println("readed");
//				PrintWriter printWriter=new PrintWriter(socket.getOutputStream());
//				
//				System.out.println("Writing");
//				printWriter.write(1);
//				printWriter.flush();
//				System.out.println("writted");
//				
//				System.out.println("Closing");
//				socket.close();
//				System.out.println("closed");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
