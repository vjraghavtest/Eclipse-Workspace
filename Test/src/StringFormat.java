
public class StringFormat {

	public static void main(String[] args) {
		String s1="2018-07-16.19.05.20.719",s2="readerdc_en_xa_install.exe",s3="hi",s4="2018-07-16.21.12.59.429",s5="ChromeSetup.exe",s6="test";
		System.out.println(s1+"\t"+s2+"\t"+s3);
		System.out.println(s4+"\t"+s5+"\t"+s6);
		System.out.printf("%s %-30s %-10s\n",s1,s2,s3);
		System.out.printf("%s %-30s %-10s",s4,s5,s6);
	}

}
