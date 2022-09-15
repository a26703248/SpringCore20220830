package spring.core.session04.sta.proxy;

public class Man implements Person{

	@Override
	public void work() {
		
		// 業務邏輯
		System.out.println("去 Google 上班");
//		測試錯誤
		System.out.println(10/0);
	}

}
