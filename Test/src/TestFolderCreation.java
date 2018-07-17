import java.io.File;

public class TestFolderCreation {

	public static void main(String[] args) {
		String path="C:\\Users\\Administrator\\Desktop\\hi\\test\\hii\\hi.txt\\";
		new File(path).mkdirs();
	}

}
