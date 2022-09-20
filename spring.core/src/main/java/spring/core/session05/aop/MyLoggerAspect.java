package spring.core.session05.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.stereotype.Component;

@Component // 可被 spring 管理的程式
@Aspect // 切面程式
public class MyLoggerAspect {
	
	@Pointcut(value = "execution(* spring.core.session05.aop.MathCalcImpl.*(..))")
	public void pt() {}
	
	@Pointcut(value = "execution(* spring.core.session05.aop.MathCalcImpl.div(..))")
	public void pt2() {}
	
	/*
//	前置通知 Advice: 執行連接點之前要執行的程式
//	@Before(value = "execution(public Integer spring.core.session05.aop.MathCalcImpl.add(Integer, Integer))") // 切入點表達式 Spring EL : execution(..) 
//	@Before(value = "execution(public Integer spring.core.session05.aop.MathCalcImpl.*(Integer, Integer))") // * 任意方法
//	@Before(value = "execution(public Integer spring.core.session05.aop.MathCalcImpl.MathCalcImpl.add(..))") // .. 表示方法中有 0~n 個參數
//	@Before(value = "execution(* spring.core.session05.aop.MathCalcImpl.add(Integer, Integer))") // * 任意權限修飾字、回傳值
//	@Before(value = "execution(* spring.core.session05.*.*(Integer, Integer))") // *.* 任意類、方法
//	@Before(value = "execution(*.*(..))") // *.*(..) 全部攔截
//	@Before(value = "pt()") // 建立攔截點
	@Before(value = "pt() && !pt2()") // 條件選擇(滿足 pt() 原則 AND(&&) 不滿足 pt2() 原則)
	public void beforeAdvice(JoinPoint joinPoint) { // JoinPoint 連接點
		String methodName = joinPoint.getSignature().getName(); // 取得方法簽章
		Object[] args = joinPoint.getArgs(); // 方法參數
		System.out.printf("前置通知 - 方法名稱: %s 方法參數: %s\n", methodName, Arrays.toString(args));
	}
	
	
//	後置通知 Advice: 執行連接點呼叫完畢之後所要執行的程式, SpringAOP 的機制上是被配置 finally 區段中
//	不論目標方法是否例外發生，都會執行後置通知
//	無法再後置通知中得到目標方法的回傳值
	@After(value = "pt()")
	public void afterAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.printf("後置通知 - 方法名稱: %s\n", methodName);
	}
	
//	返回通知 Advice: 可以得到目標方法的回傳值
//	不過若目標方法發生例外，則返回通知不會執行
	@AfterReturning(value = "pt()", returning="result") // 設定將目標方法的回傳值放到 result 變數中
	public void AfterReturningAdvice(JoinPoint joinPoint, Object result) { // result 取得目標方法的回傳值(必須搭配上面 returning="result" 的設定)
		String methodName = joinPoint.getSignature().getName();
		System.out.printf("返回通知 - 方法名稱: %s 該方法回傳值: %s\n", methodName, result);
	}
	
	
//	異常通知 Advice: 可以捕獲目標方法因執行時所引發的錯誤例外
	@AfterThrowing(value = "pt()", throwing = "ex") // 設定將目標方法的所拋出錯誤資訊放到 ex 變數中 
	public void AfterThrowingAdvice(JoinPoint joinPoint, Throwable ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.printf("異常通知 - 方法名稱: %s 該方法錯誤資訊: %s\n", methodName, ex);		
	}*/
	
//	環繞通知(功能強)
//	使用注意: 啟用前環繞通知時，建議先將其他通知作移除，交容易閱讀執行結果
//	環繞通知可以改變前端收到結果，也可以決定是否要執行目標方法
	@Around(value = "pt()")
	private Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object result = null; 
		String methodName = proceedingJoinPoint.getSignature().getName();
		Object[] args = proceedingJoinPoint.getArgs(); // 方法參數
		System.out.printf("環繞下的前置通知 - 方法名稱: %s 方法參數: %s\n", methodName, Arrays.toString(args));
//		目標方法業務邏輯(一定要加入)
		try {
			result = proceedingJoinPoint.proceed();
			System.out.printf("返回通知 - 方法名稱: %s 該方法回傳值: %s\n", methodName, result);
		} catch (Throwable e) {
			result = null;
			System.out.printf("異常通知 - 方法名稱: %s 該方法錯誤資訊: %s\n", methodName, e);
		} finally {			
			System.out.printf("環繞下的後置通知 - 方法名稱: %s\n", methodName);
		}
		return result;
	}
}
