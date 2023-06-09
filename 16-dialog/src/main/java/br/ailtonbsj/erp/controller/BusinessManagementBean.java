package br.ailtonbsj.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.ailtonbsj.erp.model.Company;
import br.ailtonbsj.erp.repository.Companies;
import br.ailtonbsj.erp.util.FacesMessages;

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
	
	@Inject
	private FacesMessages messages;
	
	private List<Company> listOfCompanies;
	
	private String searchTerm;
		
	public void fetch() {
		listOfCompanies = companies.fetch(searchTerm);
		if(listOfCompanies.isEmpty()) {
			messages.info("Consulta não retornou registros.");
		}
	}
	
	public void listAllCompanies() {
		listOfCompanies = companies.listAll();
	}

	public List<Company> getListOfCompanies() {
		return listOfCompanies;
	}

	public void setListOfCompanies(List<Company> listOfCompanies) {
		this.listOfCompanies = listOfCompanies;
	}
	
	public String getSearchTerm() {
		return searchTerm;
	}
	
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
}
