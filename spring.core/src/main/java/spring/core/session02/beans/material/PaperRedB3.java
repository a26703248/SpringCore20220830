package spring.core.session02.beans.material;

public class PaperRedB3 {
	private Integer id; // 編號
	private Color red; // 紅色
	private Size b3; // B3 尺寸
	
	
	public PaperRedB3() {
	}


	public PaperRedB3(Color red, Size b3) {
		this.red = red;
		this.b3 = b3;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Color getRed() {
		return red;
	}


	public void setRed(Color red) {
		this.red = red;
	}


	public Size getB3() {
		return b3;
	}


	public void setB3(Size b3) {
		this.b3 = b3;
	}


	@Override
	public String toString() {
		return "PaperRedB3 [id=" + id + ", red=" + red + ", b3=" + b3 + "]";
	}
	
}
