package cs.vsb.fei.veaHomework.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ReportItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String text;
	private int points;
	
	@ManyToOne
	private ReportExtended reportExtended;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public ReportExtended getReportExtended() {
		return reportExtended;
	}

	public void setReportExtended(ReportExtended reportExtended) {
		this.reportExtended = reportExtended;
	}

	public ReportItem(long id, String text, int points, ReportExtended reportExtended) {
		super();
		this.id = id;
		this.text = text;
		this.points = points;
		this.reportExtended = reportExtended;
	}

	public ReportItem() {
		super();
	}
	
	
}
