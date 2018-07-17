import java.io.IOException;

public class StopSocket {

	public static void main(String[] args) throws IOException {
		Server.socket.close();
	}

}
