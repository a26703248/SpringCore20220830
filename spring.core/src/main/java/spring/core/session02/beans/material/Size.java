package spring.core.session02.beans.material;

//尺寸
public class Size {
	
	private String name; // 尺寸型號

	public Size() {
	}

	public Size(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Size [name=" + name + "]";
	}
	
}
