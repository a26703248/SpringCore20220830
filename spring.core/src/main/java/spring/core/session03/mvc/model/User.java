package spring.core.session03.mvc.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // 是一個可以被 Spring 管理的物件
@Scope("prototype")
@PropertySource("classpath:user.properties")
public class User { // 使用者模型
	
//	@Value(value = "John") // 配置預設值
	@Value("${user.username}")
	private String username; // 姓名
	
//	@Value(value = "18")
	@Value("${user.age}")
	private Integer age; // 年齡
	
//	@Value(value = "#{${nickname: {'foo', 'bar'}}}") // 使用 spring EL 語法(#=系統的, $=變數)
	@Value("${user.nicknames}")
	private String[] nicknames; // 暱稱
	
//	@Value(value = "#{${subject: {'Python', 'Java'}}}")
	@Value("${user.subject}")
	private Set<String> subject; // 專長科目
	
//	@Value(value = "#{${score: {100, 90}}}")
	@Value("#{'${user.score}'.split}") // List 因為內建型態為int,所以需要特殊處理
	private List<Integer> score; // 各科成績
	
//	@Value(value = "#{${hobbies: {'h1':'Program', 'h2':'Game'}}}")
	@Value("${user.hobbies}")
	private Map<String, String> hobbies; // 興趣
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String[] getNicknames() {
		return nicknames;
	}

	public void setNicknames(String[] nicknames) {
		this.nicknames = nicknames;
	}

	public Set<String> getSubject() {
		return subject;
	}

	public void setSubject(Set<String> subject) {
		this.subject = subject;
	}

	public List<Integer> getScore() {
		return score;
	}

	public void setScore(List<Integer> score) {
		this.score = score;
	}

	public Map<String, String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Map<String, String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + ", nickname=" + Arrays.toString(nicknames) + ", subject="
				+ subject + ", score=" + score + ", hobbies=" + hobbies + "]";
	}
}

