package br.ailtonbsj.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ailtonbsj.erp.model.Company;

public class Companies implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Companies() {
	}
	
	public Companies(EntityManager manager) {
		this.manager = manager;
	}

	public Company byId(Long id) {
		return manager.find(Company.class, id);
	}
	
	public List<Company> listAll() {
		return manager.createQuery("from Company", Company.class).getResultList();
	}
	
	public List<Company> fetch(String name) {
		// Using JPQL
		TypedQuery<Company> q = manager
				.createQuery("from Company where corporateName like :corporateName", Company.class);
		q.setParameter("corporateName", "%" + name + "%");
		return q.getResultList();
	}
	
	public Company save(Company company) {
		return manager.merge(company);
	}
	
	public void remove(Company company) {
		company = byId(company.getId());
		manager.remove(company);
	}

}
