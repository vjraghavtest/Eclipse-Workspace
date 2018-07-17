import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {

	public static void main(String[] args) throws IOException {
		InputStream initialStream = new FileInputStream(
			      new File("D:\\Default Software's-E7450\\ChromeSetup.exe"));
			    File targetFile = new File("C:\\Users\\Administrator\\Desktop\\output.exe");
			    BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(targetFile));
			 
			    byte[] buffer = new byte[8*1024];
			    int bytesRead;
			    while ((bytesRead = initialStream.read(buffer)) != -1) {
			    	System.out.println("bytes read"+bytesRead);
			        outStream.write(buffer, 0, bytesRead);
			    }
	}

}
