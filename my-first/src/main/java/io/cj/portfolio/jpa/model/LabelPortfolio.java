package io.cj.portfolio.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private Long portfolioid;

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

	public Long getPortfolioid() {
		return portfolioid;
	}

	public void setPortfolioid(Long portfolioid) {
		this.portfolioid = portfolioid;
	}
}
