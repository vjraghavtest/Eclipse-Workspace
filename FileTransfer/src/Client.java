import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public final static String HOST = "127.0.0.1";

	public static void main(String[] args) throws IOException {
		// Socket socket=null;
		// InputStream inputStream=null;
		// FileOutputStream fileOutputStream=null;
		// BufferedOutputStream bufferedOutputStream=null;
		//
		// int bytesRead,currentTotal=0;
		//
		// String path="C:\\Users\\Administrator\\Desktop\\output.exe";
		// int size=987728;
		// try {
		// System.out.println("socket stating");
		// socket=new Socket(HOST, Server.PORT);
		// } catch (UnknownHostException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// try {
		// System.out.println("connected");
		// inputStream=socket.getInputStream();
		// System.out.println("got in stream");
		// fileOutputStream=new FileOutputStream(path);
		// bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
		// byte[] fileData=new byte[size];
		// System.out.println("op file prepared");
		// bytesRead=inputStream.read(fileData, 0, size);
		// System.out.println("read file from in stream");
		// currentTotal=bytesRead;
		// System.out.println("current total "+currentTotal+" bytesread
		// "+bytesRead);
		// do {
		// System.out.println("current total "+currentTotal+" bytesread
		// "+bytesRead);
		// bytesRead =inputStream.read(fileData, currentTotal ,
		// (fileData.length-currentTotal));
		// if(bytesRead >= 0) currentTotal += bytesRead;
		// } while(bytesRead > -1);
		//
		// System.out.println("File readed");
		// bufferedOutputStream.write(fileData, 0, currentTotal);
		// System.out.println("Writen to op file");
		// bufferedOutputStream.flush();
		// bufferedOutputStream.close();
		// socket.close();
		//
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		int filesize = 4203840;
		int bytesRead = 0;
		int currentTot = 0;
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", Server.PORT);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] bytearray = new byte[1024];
		InputStream is = null;
		try {
			is = socket.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\output-test.exe");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		try {
			bytesRead = is.read(bytearray, 0, bytearray.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		currentTot = bytesRead;
		//
		// do {
		// try {
		// bytesRead =
		// is.read(bytearray, currentTot, (bytearray.length-currentTot));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// if(bytesRead >= 0) currentTot += bytesRead;
		// } while(bytesRead > -1);

		while ((bytesRead = is.read(bytearray)) > -1) {
			System.out.println("Receiving");
//			;
//			if (bytesRead > -1) {
//				currentTot += bytesRead;
				System.out.println(bytesRead + " bytes received");
				bos.write(bytearray, 0, bytesRead);
				System.out.println(bytesRead + " bytes written to file");
//			} else
//				break;

		}
		System.out.println("Done");
		try {
			bos.flush();
			bos.close();
			is.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
