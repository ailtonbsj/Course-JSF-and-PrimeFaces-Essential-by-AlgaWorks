package br.ailtonbsj.erp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ailtonbsj.erp.model.Company;

public class SchemaGeneration {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ErpPU");
		EntityManager em = emf.createEntityManager();

		List<Company> list = em.createQuery("from Company", Company.class).getResultList();

		System.out.println(list);

		em.close();
		emf.close();
	}
}
