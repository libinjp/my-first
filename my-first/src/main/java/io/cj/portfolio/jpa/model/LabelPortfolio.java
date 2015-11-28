package io.cj.portfolio.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class LabelPortfolio {
	public LabelPortfolio(){
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Long labelid;

	@Column(nullable = false)
	private Long loginId;

	@Column(nullable = false)
	private String labelDisplay;

	@ManyToOne
	@JoinColumn(name = "portfolioid")
	@JsonBackReference // this annotation prevents the exception
	private Portfolio portfolio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLabelid() {
		return labelid;
	}

	public void setLabelid(Long labelid) {
		this.labelid = labelid;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getLabelDisplay() {
		return labelDisplay;
	}

	public void setLabelDisplay(String labelDisplay) {
		this.labelDisplay = labelDisplay;
	}
}
