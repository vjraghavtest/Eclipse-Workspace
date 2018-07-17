import java.util.ArrayList;

public class StringArray {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hi");
		list.add("hello");
		list.add("end");
		String[] array = new String[list.size()];
		array = list.toArray(array);
		for (String s : array) {
			System.out.println(s);
		}
	}
}
