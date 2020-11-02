package cs.vsb.fei.veaHomework.businessLogic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.vsb.fei.veaHomework.dao.ReportDao;
import cs.vsb.fei.veaHomework.entities.Report;

@Service
public class ReportService {

	
	@Autowired
	private ReportDao reportDao;
	
	public ReportService() {
		
	}
	
	@PostConstruct
	public void init() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
		Date date = new Date();  
	    System.out.println(formatter.format(date));  
		reportDao.insert(new Report("Nadpis jak pes", "Tohleto je popisek", date, 'F'));
		reportDao.insert(new Report("Nadpis jak pes2", "Tohleto je popisek2", date, 'L'));
	}
	
	public void saveReport(Report report) {
		reportDao.insert(report);
	}
	
	public List<Report> getAll(){
		
		return reportDao.getAll();
	}
	
	public Report find(long id) {
		
		return reportDao.find(id);
	}
}
