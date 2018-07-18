
public class TestENV {
	public static void main(String[] args) {
//		System.out.println(System.getenv("HOME"));
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.home")+System.getProperty("file.separator")+"Server"+System.getProperty("file.separator"));
	}
}
