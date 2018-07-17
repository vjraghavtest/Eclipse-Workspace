import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class TestFIle {

	public static void main(String[] args) throws IOException {
//		String path="C:\\Users\\Administrator\\Desktop\\"+new SimpleDateFormat("yyyy-
//		MM-dd").format(new java.util.Date())+"-server-log-test.log";
		String path="C:\\Users\\Administrator\\Desktop\\2018-07-16-server-log.log";
		FileOutputStream fileOutputStream=new FileOutputStream(new File(path),true);
		
		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
		
		
		bufferedOutputStream.write("-----------------------------------------------------------------------------------\n".getBytes());
		
		bufferedOutputStream.close();
	}

}
