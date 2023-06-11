package br.ailtonbsj.erp.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.ailtonbsj.erp.model.ActivityBranch;

public class ActivityBranchConverter implements Converter {

	private List<ActivityBranch> activityBranchList;
	
	public ActivityBranchConverter(List<ActivityBranch> activityBranchList) {
		this.activityBranchList = activityBranchList;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null) return null;
		ActivityBranch obj = null;
		for (ActivityBranch activityBranch : activityBranchList) {
			if(activityBranch.getId().toString() == value)
				obj = activityBranch;
		}
		return obj;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) return null;
		ActivityBranch activityBranch = (ActivityBranch) value;
		return activityBranch.getId().toString();
	}

}
