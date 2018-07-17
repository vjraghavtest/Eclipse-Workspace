
public class TestThread extends Thread{
	public void run(){
		System.out.println("In thread");
	}
}

class Main{
	public static void main(String[] args) {
		TestThread thread=new TestThread();
		thread.start();
		System.out.println(thread.getName());
	}
}