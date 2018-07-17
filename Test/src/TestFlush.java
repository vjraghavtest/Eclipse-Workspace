import java.io.PrintWriter;

public class TestFlush {
	public static void main(String[] args) {
		PrintWriter writer=new PrintWriter(System.out);
		
		writer.println("HI");
		
		writer.println("hi");
		
		writer.write("hiii");
		
		writer.flush();
		
		writer.println("hi1");
	}
}
