package cs.vsb.fei.veaHomework.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import cs.vsb.fei.veaHomework.entities.Report;
import cs.vsb.fei.veaHomework.entities.ReportMapper;



public class ReportDaoJdbc {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert reportInsert;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		reportInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("report").usingGeneratedKeyColumns("id")
				.usingColumns("title", "description","date","evaluation");
 	}
	
	
	@PostConstruct
	public void postConstructor() {
		try {
			String dbProducerName;
			try (Connection con = jdbcTemplate.getDataSource().getConnection()){
				DatabaseMetaData metaData = con.getMetaData();
				dbProducerName = metaData.getDatabaseProductName();				
			}
			String sqlCreateTable;
			if("ApacheDerby".equals(dbProducerName)) {
				sqlCreateTable = "CREATE TABLE report (id INTEGER NOT NULL "
						+ "GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
						+ "title varchar(255), description varchar(1000), "
						+ "date TIMESTAMP, evaluation char(1)";
			}
			else if ("H2".equals(dbProducerName)) {
				sqlCreateTable = "create table report(id INTEGER NOT NULL " + "AUTO_INCREMENT," + " title varchar(255), "
						+ "description varchar(255), " + "date TIMESTAMP, "+"evaluation char(1));";
			}
			else {
				throw new RuntimeException("Unsuported database type");
			}
			jdbcTemplate.update(sqlCreateTable);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(DataAccessException e) {
			System.out.println("Table already exist.");
		}
	}
	
	public Report insert(Report report) {
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(report);
		Number key = reportInsert.executeAndReturnKey(source);
		report.setId(key.longValue());
		return report;
	}
	
	public List<Report> getAll(){
		return jdbcTemplate.query("select * from Person", new ReportMapper());
	}
	
	public Report find(long id) {
		return jdbcTemplate.queryForObject("select * from Report where id=?", new Object[] {Long.valueOf(id)} , new ReportMapper());
	}
	
}
