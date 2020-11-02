package cs.vsb.fei.veaHomework.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class ReportExtended extends Report{

	@NotEmpty
	private int Creator;

	@OneToMany(mappedBy = "reportExtended")
	private List<ReportItem> reportItems;

	public int getCreator() {
		return Creator;
	}

	public void setCreator(int creator) {
		Creator = creator;
	}

	public List<ReportItem> getReportItems() {
		return reportItems;
	}

	public void setReportItems(List<ReportItem> reportItems) {
		this.reportItems = reportItems;
	}

	public ReportExtended() {
		super();
	}
	
	public ReportExtended(long id, @NotEmpty String title, @NotEmpty String description, 
			@NotEmpty Date date, @NotEmpty char evaluation) {
		super(id, title, description, date, evaluation);
	}

	public ReportExtended(long id, @NotEmpty String title, @NotEmpty String description, @NotEmpty Date date, 
			@NotEmpty char evaluation, @NotEmpty int creator, List<ReportItem> reportItems) {
		super(id, title, description, date, evaluation);
		Creator = creator;
		this.reportItems = reportItems;
	}
	
	
	
}
