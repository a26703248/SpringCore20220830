package spring.core.session04.dyn.cglib;


//Enchancer 增強
//EnchancerHello 子類別具有父類別的特性
public class EnchancerHello extends Hello{

	@Override
	public String sayHello(String str) {
		String message = "請出示實聯 QRcode";
		return super.sayHello(str) + message;
	}
	
}
