package br.ailtonbsj.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.ailtonbsj.erp.model.Company;
import br.ailtonbsj.erp.repository.Companies;
import br.ailtonbsj.erp.util.Transacional;

public class RegisterCompanyService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Companies companies;
	
	@Transacional
	public void save(Company company) {
		companies.save(company);
	}
	
	@Transacional
	public void remove(Company company) {
		companies.remove(company);
	}
	
}
