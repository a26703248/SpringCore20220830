package spring.core.session03.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Teacher {
	private Integer id;
	private String name;
	private Set<Student> students;
	private List<String> subject;
	private Map<String, Integer> salary;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Student> getStudents() {
		return students;
	}


	public void setStudents(Set<Student> students) {
		this.students = students;
	}


	public List<String> getSubject() {
		return subject;
	}


	public void setSubject(List<String> subject) {
		this.subject = subject;
	}


	public Map<String, Integer> getSalary() {
		return salary;
	}


	public void setSalary(Map<String, Integer> salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", students=" + students + ", subject=" + subject + ", salary="
				+ salary + "]";
	}
	
}
