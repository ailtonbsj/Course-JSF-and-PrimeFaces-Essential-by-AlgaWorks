package br.ailtonbsj.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ailtonbsj.erp.model.ActivityBranch;

public class ActivitiesBraches implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public ActivitiesBraches(EntityManager manager) {
		this.manager = manager;
	}

	public List<ActivityBranch> fetch(String description) {
		// Using Criteria
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<ActivityBranch> cq = cb.createQuery(ActivityBranch.class);
		Root<ActivityBranch> root = cq.from(ActivityBranch.class);
		cq.select(root);
		cq.where(cb.like(root.get("description"), description + "%"));
		TypedQuery<ActivityBranch> q = manager.createQuery(cq);
		return q.getResultList();
	}
}
