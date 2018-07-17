import java.io.Serializable;

public class TestClass implements Serializable{
	private String name=null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
