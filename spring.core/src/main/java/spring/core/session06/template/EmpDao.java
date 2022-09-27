package spring.core.session06.template;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.core.session06.entity.Emp;
import spring.core.session06.entity.Job;

@Repository
public class EmpDao {
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
//	1. 筆查詢: 全部查詢
	public List<Map<String, Object>> queryAll() {
		String sql = "select eid, ename, age, createtime from emp";
		List<Map<String, Object>> result = jdbctemplate.queryForList(sql);
		return result;
	}
	
//	2. 多筆查詢: 全部查詢
	public List<Emp> queryAll2() {
		String sql = "select eid, ename, age, createtime from emp";
		RowMapper<Emp> rowMapper = (ResultSet rs, int rowNum) -> {
			Emp emp = new Emp();
			// emp 欄位
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setAge(rs.getInt("age"));
			emp.setCreateDate(rs.getTimestamp("createtime"));
			return emp;
		};
		List<Emp> emps = jdbctemplate.query(sql, rowMapper);
		return emps;
	}
	
//	3. 多筆查詢: 全部查詢
	public List<Emp> queryAll3() {
		String sql = "select eid, ename, age, createtime from emp";
		List<Emp> emps = jdbctemplate.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
		return emps;
	}
	
//	4. 多筆查詢: 全部查詢	(關聯欄位)
	public List<Emp> queryAll4() {
		String sql = "select eid, ename, age, createtime from emp";
		RowMapper<Emp> rowMapper = (ResultSet rs, int rowNum) -> {
			Emp emp = new Emp();
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setAge(rs.getInt("age"));
			emp.setCreateDate(rs.getTimestamp("createtime"));
			String sql2 = "select jid, jname, eid from job where eid = " + emp.getEid();
			List<Job> jobs = jdbctemplate.query(sql2, new BeanPropertyRowMapper());
			// 將 jobs 設定到 emp 中
			emp.setJobs(jobs);
			return emp;
		};
		List<Emp> emps = jdbctemplate.query(sql, rowMapper);
		return emps;
	}
	
//	5. 多筆查詢: 全部查詢	(關聯欄位)
	public List<Emp> queryAll5() {
		String sql = "select e.eid, e.ename, e.age, e.createtime, " + // emp
			     "j.jid as job_jid, j.jname as job_jname, j.eid as job_eid " + // job, 關聯外部表時要 as 加上固定格式(資料表_欄位名)
			     "from emp e left join job j on j.eid = e.eid";
		
//		資料提取器
		ResultSetExtractor<List<Emp>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("eid") // 對應 key
				.newResultSetExtractor(Emp.class); // 要注入到的物件 
		
		return jdbctemplate.query(sql, resultSetExtractor);
	}
}
