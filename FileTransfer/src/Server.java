import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public final static int PORT = 5555;

	public static void main(String[] args) {
		// ServerSocket serverSocket = null;
		// Socket socket = null;
		// OutputStream outputStream = null;
		// String path = "D:\\Default Software's-E7450\\ChromeSetup.exe";
		// File file = new File(path);
		// System.out.println(file.length());
		// try {
		// System.out.println("Server socket started");
		// serverSocket = new ServerSocket(PORT);
		// } catch (IOException e1) {
		// e1.printStackTrace();
		// }
		// try {
		// System.out.println("waiting for Connection");
		// socket = serverSocket.accept();
		// System.out.println("Connection established");
		// outputStream = socket.getOutputStream();
		// } catch (IOException e1) {
		// e1.printStackTrace();
		// }
		// try {
		// System.out.println("File read");
		// FileInputStream fileInputStream = new FileInputStream(file);
		// byte[] fileData = new byte[(int) file.length()];
		// BufferedInputStream bufferedInputStream = new
		// BufferedInputStream(fileInputStream);
		// System.out.println("File loading");
		// bufferedInputStream.read(fileData,0,fileData.length);
		// System.out.println("Writing into op stream");
		// outputStream.write(fileData,0,fileData.length);
		// System.out.println("Data sent");
		// outputStream.flush();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }finally {
		// try {
		// outputStream.close();
		// socket.close();
		// serverSocket.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }

		try {
			ServerSocket serverSocket = new ServerSocket(5555);
			int bytesRead = 0;
			byte[] buffer = new byte[1024];
			Socket socket = serverSocket.accept();
			System.out.println("Accepted connection : " + socket);
			File transferFile = new File("D:\\Default Software's-E7450\\python-3.5.1.exe");
			byte[] bytearray = new byte[(int) transferFile.length()];
			FileInputStream fin = new FileInputStream(transferFile);
			BufferedInputStream inputStream = new BufferedInputStream(fin);
			// bin.read(bytearray,0,bytearray.length);
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			System.out.println("Sending Files...");
			// os.write(bytearray,0,bytearray.length);
			while ((bytesRead = inputStream.read(buffer)) > 0) {
				System.out.println("Sent " + bytesRead + " bytes");
				outputStream.write(buffer, 0, bytesRead);
			}
			
			inputStream.close();
			outputStream.flush();
			outputStream.close();
			socket.close();
			System.out.println("File transfer complete");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
