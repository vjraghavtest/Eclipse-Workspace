import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Scanner;

public class TestObjectServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket=null;
		Socket socket=null;
		
		serverSocket=new ServerSocket(5555);
		socket=serverSocket.accept();
		
		TestClass obj=new TestClass();
		obj.setName("Raghav");
		Hashtable<String, String> data=new Hashtable<String, String>();
		
		data.put("key", "value");
		
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
		
		objectOutputStream.writeObject(data);
		new Scanner(System.in).next();
		objectOutputStream.writeObject(obj);
		objectOutputStream.flush();
		objectOutputStream.close();
		socket.close();
		serverSocket.close();
	}

}
