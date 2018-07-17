import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Scanner;

public class TestObjectClient {
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket=null;
		socket=new Socket("localhost", 5555);
		
		ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
		
		Hashtable<String, String> data=(Hashtable<String, String>) objectInputStream.readObject();
		System.out.println(data.get("key"));
//		socket.close();
		new Scanner(System.in).next();
		TestClass obj=(TestClass)objectInputStream.readObject();
		System.out.println(obj.getName());
		objectInputStream.close();
		socket.close();
	}
}
