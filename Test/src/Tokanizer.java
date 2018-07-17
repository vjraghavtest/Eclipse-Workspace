import java.util.StringTokenizer;

public class Tokanizer {

	public static void main(String[] args) {
		String s="data<path|data<path|";
		
		StringTokenizer stringTokenizer=new StringTokenizer(s, "|");
		while(stringTokenizer.hasMoreTokens()){
			StringTokenizer stringTokenizer2=new StringTokenizer(stringTokenizer.nextToken(), "<");
			while(stringTokenizer2.hasMoreTokens()){
				System.out.println(stringTokenizer2.nextToken());
			}
		}
		System.out.println("END");
	}

}
