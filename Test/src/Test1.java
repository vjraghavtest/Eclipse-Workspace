
public class Test1 {
	public static void main(String[] args) {
		int a[]=new int[20];
		a[5]=5;
		int b[]=a;
		a[5]=10;
		System.out.println(b[5]);
		System.out.println(new java.util.Scanner(System.in).nextLine());
	}
}
