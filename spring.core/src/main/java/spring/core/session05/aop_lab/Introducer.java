package spring.core.session05.aop_lab;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class Introducer { // 經理人
//	將 Performance 及其子類類別轉為 Singer
	@DeclareParents(value="spring.core.session05.aop_lab.Performance+", defaultImpl = BackSinger.class)
	public Singer singer;
}
