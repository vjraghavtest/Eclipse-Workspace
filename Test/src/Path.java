import java.io.File;
import java.util.Scanner;

public class Path {

	public static void main(String[] args) {
		String path=new Scanner(System.in).nextLine();
		System.out.println(path);
//		path="C:\\Users\\Administrator\\Desktop\\test.txt";
		System.out.println(path);
		
//		path=path.replace("\\", "\\\\");
		path=path.replace("\"", "");
		File file=new File(path);
		System.out.println(path);
		System.out.println(file.isFile());
	}

}
