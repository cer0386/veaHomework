package cs.vsb.fei.veaHomework.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cs.vsb.fei.veaHomework.entities.Report;


@Transactional
@Repository
public class ReportDaoJpa implements ReportDao{

	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void postConstructor() {
		
	}
	
	
	public Report insert(Report report) {
		em.persist(report);
		return report;
	}

	public List<Report> getAll() {
		return em.createQuery("select r from Report r", Report.class).getResultList();
	}

	public Report find(long id) {
		return em.find(Report.class, id);
	}

	
}
