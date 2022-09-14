package spring.core.session04.sta.proxy;

public class Woman implements Person{

	@Override
	public void work() {
		
		// 業務邏輯
		System.out.println("去市場買菜");
	}

}
