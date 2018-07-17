import java.security.Timestamp;
import java.text.SimpleDateFormat;

public class TestTimestamp {

	public static void main(String[] args) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new java.util.Date());
		System.out.println(timeStamp);
	}

}
