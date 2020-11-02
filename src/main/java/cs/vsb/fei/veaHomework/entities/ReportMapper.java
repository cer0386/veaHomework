package cs.vsb.fei.veaHomework.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReportMapper implements RowMapper<Report>{
	
	@Override
	public Report mapRow(ResultSet rs, int rowNum) throws SQLException{
		return new Report(rs.getLong("id"), rs.getString("title"), rs.getString("description"),
				rs.getDate("date"), rs.getString("evaluation").charAt(0));
	}
}
