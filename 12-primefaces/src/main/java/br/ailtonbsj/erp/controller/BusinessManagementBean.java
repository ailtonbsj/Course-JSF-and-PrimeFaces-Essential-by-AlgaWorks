package br.ailtonbsj.erp.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.ailtonbsj.erp.model.Company;
import br.ailtonbsj.erp.model.CompanyType;

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
	
	private Company company = new Company();
	
	public void save() {
		System.out.println(this.company.getCorporateName() + " - " +
				this.company.getFantasyName() + " - " +
				this.company.getType());
	}
	
	public String help() {
		return "HelpBusinessManagement?faces-redirect=true";
	}
	
	public Company getCompany() {
		return company;
	}
	
	public CompanyType[] getCompanyTypes() {
		return CompanyType.values();
	}
}
