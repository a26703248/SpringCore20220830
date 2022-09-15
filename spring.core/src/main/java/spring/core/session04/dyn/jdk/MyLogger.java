package spring.core.session04.dyn.jdk;

import java.lang.reflect.Method;
import java.util.Arrays;


// MyLogger 就是公用程式(也就是切面(方面)導向設計: Aspect Oriented Programming)
public class MyLogger {
//	Before: 前置通知(在執行方法前所要執行的程式), Advice(具體的實作)
	public static void before(Method method, Object[] args) {
		System.out.printf("Before: 前置通知: %s 準備開始計算, 參數: %s\n", method.getName(), Arrays.toString(args));
	}
//	Exception: 例外異常通知(在執行方法時所要發生的錯誤)
	public static void throwing(Method method, Exception e) {
		System.out.printf("Exception: 例外異常通知: %s 方法發生例外, 訊息: %s\n", method.getName(), e);
	}
//	End: 例外異常通知(在執行方法後所要執行的程式)
	public static void end(Method method) {
		System.out.printf("End: 後置通知: %s 方法計算完成\n", method.getName());
	}
}
