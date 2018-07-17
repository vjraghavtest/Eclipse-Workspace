
public class c {

	public static void main(String[] args) {
		b obj=new b();
		obj.set();
		obj.print();
		obj.detail.get("key").setAbc(200);
		obj.print();
		d obj1=new d();
		obj1.change(obj.detail.get("key1"));
		obj.print();
	}

}
