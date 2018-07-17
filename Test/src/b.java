import java.util.LinkedHashMap;

public class b {
	LinkedHashMap<String, a> detail;
	b(){
		detail=new LinkedHashMap<>();
	}
	public void set(){
		detail.put("key", new a());
		a obj1=new a();
		obj1.setAbc(10);
		detail.put("key1", obj1);
	}
	
	public void print(){
		for(a obj:detail.values()){
			System.out.println(obj.getAbc());
		}
	}
}
