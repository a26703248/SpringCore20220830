package spring.core.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//Spring jdbc - java 配置可以取代傳統的 jdbc-config.xml 配置
@Configuration //宣告此類是一個配置定義
@ComponentScan(basePackages = {"spring.core.session06", "spring.core.session07"})
@PropertySource(value = {"classpath:db.properties"}, ignoreResourceNotFound = true) // 指定連線屬性資源檔(忽略尋找不到錯誤)
@EnableTransactionManagement // 啟動交易管理機制
public class SpringJdbcConfig {
	
	@Autowired
	private Environment env; // 透過 env 可以取得外部資源配置檔(db.properties)
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			// basic
			ds.setDriverClass(env.getProperty("jdbc.driver"));
			ds.setJdbcUrl(env.getProperty("jdbc.url"));
			ds.setUser(env.getProperty("jdbc.username"));
			ds.setPassword(env.getProperty("jdbc.password"));
			
			// options
			ds.setMinPoolSize(10);
			ds.setMaxPoolSize(100);
			ds.setInitialPoolSize(10);
			ds.setMaxIdleTime(100); // 秒
			ds.setMaxStatements(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public NamedParameterJdbcTemplate nameParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
