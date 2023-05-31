package br.ailtonbsj.erp.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ailtonbsj.erp.model.ActivityBranch;
import br.ailtonbsj.erp.model.Company;
import br.ailtonbsj.erp.model.CompanyType;

public class PersistenceLayer {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ErpPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		ActivitiesBraches activitiesBranches = new ActivitiesBraches(em);
		Companies companies = new Companies(em);
		
		List<ActivityBranch> listActivitiesBranches = activitiesBranches.fetch("");
		List<Company> listCompanies = companies.fetch("");
		System.out.println(listCompanies);
		
		Company company = new Company();
		company.setFantasyName("João da Silva");
		company.setCnpj("41.952.519/0001-57");
		company.setCorporateName("João da Silva 41952519000157");
		company.setType(CompanyType.MEI);
		company.setFundationDate(new Date());
		company.setActivityBranch(listActivitiesBranches.get(0));
		
		companies.save(company);
		
		em.getTransaction().commit();
		
		List<Company> listCompanies2 = companies.fetch("");
		System.out.println(listCompanies2);
		
		em.close();
		emf.close();
	}

}
