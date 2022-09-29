package spring.core.session06.template;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.Nullable;
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
			emp.setCreateTime(rs.getTimestamp("createtime"));
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
			emp.setCreateTime(rs.getTimestamp("createtime"));
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
		ResultSetExtractor<List<Emp>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance().addKeys("eid") // 對應key
				.newResultSetExtractor(Emp.class); // 要注入到的物件

		return jdbctemplate.query(sql, resultSetExtractor);
	}

//	6. 多筆查詢: 全部查詢	(關聯欄位)
	public List<Job> queryJobs() {
		String sql = "select j.jid, j.jname , j.eid,\r\n"
				+ "e.eid as emp_eid, e.ename as emp_ename, e.age as emp_age, e.createtime as emp_createtime \r\n"
				+ "from job j left join emp e on j.eid = e.eid\r\n" + "";

//		資料提取器
		ResultSetExtractor<List<Job>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance().addKeys("jid") // 對應key
				.newResultSetExtractor(Job.class); // 要注入到的物件

		return jdbctemplate.query(sql, resultSetExtractor);
	}
	
//	多筆查詢: 
//	取得某單一員工的job
	public List<Job> queryJobsByEid(Integer eid) {
		String sql = "select jid, jname, eid from job where eid = ?";
		List<Job> jobs = jdbctemplate.query(sql, new BeanPropertyRowMapper<Job>(Job.class), eid);
		return jobs;
	}
	
	
//	單筆查詢: Emp
	public Emp getEmpById(Integer id) {
		String sql = "select eid, ename, age, createtime from emp where eid = ?";
//		Object[] args = {id};
//		queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args) throws DataAccessException
//		return jdbctemplate.queryForObject(sql, args, new BeanPropertyRowMapper<Emp>(Emp.class));
		
		// queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args) throws DataAccessException
//		return jdbctemplate.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class), id);
		Emp emp = null;
		try {
			emp = jdbctemplate.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class), id);
		} catch (DataAccessException e) {
			System.out.println("查無此人:" + e);
		}		
		return emp;
	}
	
//	單筆查詢: Emp
	public Emp getEmpById(Integer id, Boolean hasRelative) {
		Emp emp = this.getEmpById(id);
		
//		emp 不需要關連到job
		if(!hasRelative) {
			return emp;
		}
//		emp 需要關連到job* (0...多筆)
		List<Job> jobs = this.queryJobsByEid(id);
		// 將 jobs 配置注入到 emp 物件
		emp.setJobs(jobs);
		return emp;
	}
	
//	單筆查詢: Job
	public Job getJobById(Integer id) {
		String sql = "select jid, jname, eid from job where jid = :job_id";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("job_id", id);
		Job job = null;
		try {
			job = namedParameterJdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<Job>(Job.class));
		} catch (DataAccessException e) {			
			System.out.println("查無此工作:" + e);
		}
		return job;
	}
	
	
//	單筆查詢
//	若 hasRelative = true,則會找出job 所對應的 emp 物件
	public Job getJobById(Integer id, Boolean hasRelative) {
		Job job = this.getJobById(id);
		if(!hasRelative) {
			return job;
		}
		Emp emp = this.getEmpById(job.getEid(), true);
		job.setEmp(emp);
		return job;
	}
	
//	單筆單筆新增 I
	public int addEmpOne1(String ename, Integer age) {
		String sql = "insert into emp(ename, age) values(?, ?)";
		int rowCount = jdbctemplate.update(sql, ename, age);
		return rowCount;
	}
	
//	單筆單筆新增 II
	public int addEmpOne2(String ename, Integer age) {
		String sql = "insert into emp(ename, age) values(:emp_name, :emp_age)";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("emp_name", ename)
				.addValue("emp_age", age);
		int rowCount = namedParameterJdbcTemplate.update(sql, params);
		return rowCount;
	}
	
//	批次(多筆)新增 I
	public int[] batchAdd(List<Object[]> rows) {
		String sql = "insert into emp(ename, age) values(?, ?)";
		int[] rowCount = jdbctemplate.batchUpdate(sql, rows);
		return rowCount;
	}
	
//	批次(多筆)新增 II
	public int[] batchAdd2(List<Emp> emps) {
		String sql = "insert into emp(ename, age) values(?, ?)";
		BatchPreparedStatementSetter pss = new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// ps = sql 語法, i = 陣列索引
				ps.setString(1, emps.get(i).getEname());
				ps.setInt(2, emps.get(i).getAge());
			}
			
			@Override
			public int getBatchSize() {
				return emps.size();
			}
			
		};
		return jdbctemplate.batchUpdate(sql, pss);
	}
	
	
//	修改 I
	public int updateEnameAndAgebyId(Integer eid, String ename, Integer age) {
		String sql = "update emp set ename=?, age=? where eid= ?";
		return jdbctemplate.update(sql, ename, age, eid);
	}
//	修改 II
	public int updateEnameAndAgebyEmp(Emp emp) {
		String sql = "update emp set ename=?, age=?  where eid = ?";
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, emp.getEname());
				ps.setInt(2, emp.getAge());
				ps.setInt(3, emp.getEid());
			}
		};
		return jdbctemplate.update(sql, pss);
//		return this.updateEnameAndAgebyId(emp.getEid(), emp.getEname(), emp.getAge());
	}
	
//	刪除
	public int deleteById(Integer eid) {
		String sql = "delete from emp where eid = ?";
		return jdbctemplate.update(sql, eid); // 刪除一樣是調用 update() 方法
	}
	
}

