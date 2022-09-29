package spring.core.session06.entity;

import java.nio.file.FileSystemAlreadyExistsException;
import java.util.Date;
import java.util.List;

public class Emp {
	private Integer eid;
	private String ename;
	private Integer age;
	private Date createTime;
	
	
	private List<Job> jobs;
	
	public Emp() {
		super();
	}
	

	public Emp(String ename, Integer age) {
		super();
		this.ename = ename;
		this.age = age;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", age=" + age + ", createTime=" + createTime + ", jobs=" + jobs
				+ "]";
	}

}
