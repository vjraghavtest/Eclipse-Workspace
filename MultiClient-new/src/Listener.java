import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Listener extends Thread {
	Socket socket=null;
	BufferedReader reader=null;
	String msg=null;
	Listener(Socket socket){
		this.socket=socket;
	}
	
	public void run(){
		try {
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true){
			try {
				msg=reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(msg.equals("END")){
				try {
					socket.close();
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			System.out.println("Response is "+msg);
		}
	}
}
