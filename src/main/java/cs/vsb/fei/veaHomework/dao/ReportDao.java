package cs.vsb.fei.veaHomework.dao;

import java.util.List;

import cs.vsb.fei.veaHomework.entities.Report;

public interface ReportDao {
	
	Report insert (Report report);
	List<Report> getAll();
	Report find(long id);
	
}
