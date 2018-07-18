import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

	public static void main(String[] args) {
		Pattern pattern=Pattern.compile("\\p{Lower}+\\@\\p{Lower}+\\.\\p{Lower}+");
		Matcher matcher=pattern.matcher("vj@hi.com");
		System.out.println(matcher.matches());
		for(String s:"2018-07-17.18.45.52.860|jdk-8u77-windows-x64.exe|test|196408376".split("\\|"))
			System.out.println(s);
	}

}
