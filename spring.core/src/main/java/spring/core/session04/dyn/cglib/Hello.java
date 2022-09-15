package spring.core.session04.dyn.cglib;

public class Hello {
	
	public String sayHello(String str) { // 方法簽章
		return "sayHello:歡迎光臨" + str + "!";
	}
	
	public String info(String str) {
		return "info:歡迎光臨" + str + "!";
	}
}
