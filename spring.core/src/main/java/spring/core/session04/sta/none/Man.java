package spring.core.session04.sta.none;

public class Man implements Person{

	@Override
	public void work() {
		// 公用邏輯
		System.out.println("戴口罩");
		
		// 業務邏輯
		System.out.println("去 Google 上班");
	}

}
