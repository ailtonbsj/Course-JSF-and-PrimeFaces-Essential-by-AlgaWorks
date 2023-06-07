package br.ailtonbsj.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.ailtonbsj.erp.model.Company;
import br.ailtonbsj.erp.repository.Companies;

/*
 * TYPES OF SCOPED IN JSF
 * 
 * @RequestScoped from javax.enterprise.context.RequestScoped
 * @ViewScoped from javax.faces.view.ViewScoped
 * @SessionScoped from javax.enterprise.context.SessionScoped
 * @ApplicationScoped from javax.enterprise.context.ApplicationScoped
 * */

@Named
@ViewScoped
public class BusinessManagementBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Companies companies;
	
	private List<Company> listOfCompanies;
	
	public void listAllCompanies() {
		listOfCompanies = companies.listAll();
	}

	public List<Company> getListOfCompanies() {
		return listOfCompanies;
	}

	public void setListOfCompanies(List<Company> listOfCompanies) {
		this.listOfCompanies = listOfCompanies;
	}
}
