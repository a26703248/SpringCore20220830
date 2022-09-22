package spring.core.session05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import spring.core.session05.aop_lab.Introducer;

@Configuration // 此為 Java 配置
@ComponentScan // 啟用元件掃描, 預設會掃描 AOPConfig.class 所在的目錄或其子目錄的 Java 程式檔
//@ComponentScan(basePackages = {"spring.core.session04", "spring.core.session05"}) // 自訂要掃描的目錄
@EnableAspectJAutoProxy // 開啟自動代理(預設關閉)
public class AOPConfig {
	
	@Bean
	public Introducer getIntroducer() {
		return new Introducer();
	}
}
