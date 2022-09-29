package spring.core.session06.entity;

import java.util.List;

public class Job {
//	變數/欄位
	private Integer jid;
	private String jname;
	private Integer eid;
	
	// 關聯關係
	private Emp emp; // 1 個 job 對應0 或 1個 emp

	public Job() {
		super();
	}

	public Integer getJid() {
		return jid;
	}

	public void setJid(Integer jid) {
		this.jid = jid;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Job [jid=" + jid + ", jname=" + jname + ", eid=" + eid + ", emp=" + emp + "]";
	}


}
