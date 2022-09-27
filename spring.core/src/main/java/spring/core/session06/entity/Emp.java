package spring.core.session06.entity;

import java.nio.file.FileSystemAlreadyExistsException;
import java.util.Date;
import java.util.List;

public class Emp {
	private Integer eid;
	private String ename;
	private Integer age;
	private Date createDate;
	
	
	private List<Job> jobs;
	
	public Emp() {
		super();
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}



}
