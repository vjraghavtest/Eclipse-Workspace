
public class StringSplit {

	public static void main(String[] args) {
		String s="2018-07-17.12.18.52.232|npp.6.9.1.Installer.exe|test|4203840";
		for(String str:s.split("\\p{Punct}")){
			System.out.println(str);
		}
	}

}
