package br.ailtonbsj.erp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fantasy_name", nullable = false, length = 80)
	private String fantasyName;
	
	@Column(name = "corporate_name", nullable = false, length = 120)
	private String corporateName;
	
	@Column(nullable = false, length = 18)
	private String cnpj;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fundation_date")
	private Date fundationDate;
	
	@ManyToOne
	@JoinColumn(name = "activity_branch_id", nullable = false)
	private ActivityBranch activityBranch;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private CompanyType type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getFundationDate() {
		return fundationDate;
	}

	public void setFundationDate(Date fundationDate) {
		this.fundationDate = fundationDate;
	}

	public ActivityBranch getActivityBranch() {
		return activityBranch;
	}

	public void setActivityBranch(ActivityBranch activityBranch) {
		this.activityBranch = activityBranch;
	}
	
	public CompanyType getType() {
		return type;
	}

	public void setType(CompanyType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "\nCompany [id=" + id + ", fantasyName=" + fantasyName + ", corporateName=" + corporateName + ", cnpj="
				+ cnpj + ", fundationDate=" + fundationDate + ", activityBranch=" + activityBranch + ", type=" + type
				+ "]";
	}

}
