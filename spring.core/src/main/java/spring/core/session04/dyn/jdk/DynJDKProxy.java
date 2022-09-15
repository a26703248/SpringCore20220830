package spring.core.session04.dyn.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//JDK 動態代理(代理物件必須實作介面)
public class DynJDKProxy {
//	代理的物件(只可以為 Object 型態)
	private Object object;
	
//	建構子注入要帶裡的物件實體
	public DynJDKProxy(Object object) {
		this.object = object;
	}
	
//	取得代理物件(給調用端使用)
	public Object getProxy() {
		Object proxyObject = null;
		
//		1. 類別載入器
		ClassLoader loader = object.getClass().getClassLoader();
//		2. 代理物件所實作的介面(需要一個陣列，因為一個類別會時做多個介面)
		Class[] interfaces = object.getClass().getInterfaces();
//		3. 處理代理的實現
//		實現 invoke(Object proxy, Method method, Object[] args)
		InvocationHandler invocationHandler = 	(proxy, method, args) -> {
			Object result = null;
//			Before: 前置通知
			MyLogger.before(method, args);
			try {			
			    // 執行代理物件的商業邏輯方法
				result = method.invoke(object, args);
			} catch (Exception e) {
				// Exception: 例外異常通知
				MyLogger.throwing(method, e);
			}finally {
				// End: 例外異常通知
					MyLogger.end(method);		
			}
			return result;
		};
		
		
		
//		得到代理物件的實體
		proxyObject = Proxy.newProxyInstance(loader, interfaces, invocationHandler);
		return proxyObject;
	}
	
}
