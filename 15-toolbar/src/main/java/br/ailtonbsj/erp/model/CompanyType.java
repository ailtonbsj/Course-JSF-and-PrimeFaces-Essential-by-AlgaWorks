package br.ailtonbsj.erp.model;

public enum CompanyType {
	MEI("Microempreendedor Individual"),
	EIRELI("Empresa Individual de Responsabilidade Limitada"),
	LTDA("Sociedade Limitada"),
	SA("Sociedade Anônima");
	
	private String description;
	
	private CompanyType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
