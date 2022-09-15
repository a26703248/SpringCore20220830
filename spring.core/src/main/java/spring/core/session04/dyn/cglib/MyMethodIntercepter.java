package spring.core.session04.dyn.cglib;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

//方法攔截器 (給 cglib 使用)
public class MyMethodIntercepter implements MethodInterceptor{


	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("MyMethodIntercepter:請出示實聯 QRcode");
		return proxy.invokeSuper(obj, args);
	}
	
}
