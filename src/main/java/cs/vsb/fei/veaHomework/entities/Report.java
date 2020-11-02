package cs.vsb.fei.veaHomework.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private String title;
	@NotEmpty
	private String description;
	@NotEmpty
	private Date date;
	@NotEmpty
	private char evaluation;
	
	public Report() {
		super();
	}
	
	public Report(@NotEmpty String title, @NotEmpty String description, @NotEmpty Date date,
			@NotEmpty char evaluation) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		this.evaluation = evaluation;
	}

	public Report(long id, @NotEmpty String title, @NotEmpty String description, @NotEmpty Date date,
			@NotEmpty char evaluation) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.evaluation = evaluation;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public char getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(char evaluation) {
		this.evaluation = evaluation;
	}
	
	
	
	
}
