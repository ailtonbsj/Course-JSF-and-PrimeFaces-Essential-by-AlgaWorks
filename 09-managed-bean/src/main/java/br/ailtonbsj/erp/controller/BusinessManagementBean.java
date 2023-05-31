package br.ailtonbsj.erp.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

/*
 * @RequestScoped from javax.enterprise.context.RequestScoped
 * @ViewScoped from javax.faces.view.ViewScoped
 * @SessionScoped from javax.enterprise.context.SessionScoped
 * @ApplicationScoped from javax.enterprise.context.ApplicationScoped
 * */

@Named
@ViewScoped
public class BusinessManagementBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Integer NUMBER = 0;
	
	public BusinessManagementBean() {
		NUMBER++;
	}
	
	public Integer getNumber() {
		return NUMBER;
	}
}
