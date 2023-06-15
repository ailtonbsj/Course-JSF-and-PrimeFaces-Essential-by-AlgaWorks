package br.ailtonbsj.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.ailtonbsj.erp.model.ActivityBranch;
import br.ailtonbsj.erp.model.Company;
import br.ailtonbsj.erp.model.CompanyType;
import br.ailtonbsj.erp.repository.ActivitiesBraches;
import br.ailtonbsj.erp.repository.Companies;
import br.ailtonbsj.erp.service.RegisterCompanyService;
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
	
	@Inject
	private ActivitiesBraches activitiesBraches;
	
	@Inject
	private RegisterCompanyService registerCompanyService;
	
	private Converter activityBranchConverter;
	
	private List<Company> listOfCompanies;
	
	private String searchTerm;
	
	private Company company;
	
	private boolean hadSearch() {
		return searchTerm != null && !searchTerm.equals("");
	}
	
	public void prepareNewCompany() {
		company = new Company();
	}
	
	public void prepareEditCompany() {
		activityBranchConverter = new ActivityBranchConverter(Arrays.asList(company.getActivityBranch()));
	}
	
	public void refreshRegister() {
		if(hadSearch()) fetch();
		else listAllCompanies();
	}
	
	public void save() {
		registerCompanyService.save(company);
		refreshRegister();
		messages.info("Empresa cadastrada com sucesso!");
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:companiesDataTable", "frm:messages"));
	}
	
	public void remove() {
		registerCompanyService.remove(company);
		company = null;
		refreshRegister();
		messages.info("Empresa excluída com sucesso!");
	}
		
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
	
	public CompanyType[] getCompanyTypes() {
		return CompanyType.values();
	}
	
	public List<ActivityBranch> completeActivityBranch(String term) {
		List<ActivityBranch> list = activitiesBraches.fetch(term);
		activityBranchConverter = new ActivityBranchConverter(list);
		return list;
	}

	public Converter getActivityBranchConverter() {
		return activityBranchConverter;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public boolean isCompanySelected() {
		return company != null && company.getId() != null;
	}
}
