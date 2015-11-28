package io.cj.portfolio.jpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
//基金基本情报
@Entity
public class Portfolio {

	public Portfolio(){
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//	名字
	@Column(nullable = false)
	private String name;

	//	todo ,add

	//	标签集
//    @ManyToMany(
//    		targetEntity= io.cj.portfolio.jpa.model.Label.class,
//    		cascade=CascadeType.ALL,
//    		fetch=FetchType.LAZY
//    )
//    @JoinTable(
//    	name="LabelPortfolio",
//        joinColumns={@JoinColumn(name="portfolioid")},
//        inverseJoinColumns={@JoinColumn(name="labelid")}
//    )
//    @JsonManagedReference // this annotation prevents the exception
	@OneToMany(mappedBy = "portfolio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference // this annotation prevents the exception
	private List<LabelPortfolio> labelPortfolios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<LabelPortfolio> getLabelPortfolios() {
		return labelPortfolios;
	}

	public void setLabelPortfolios(List<LabelPortfolio> labelPortfolios) {
		this.labelPortfolios = labelPortfolios;
	}

}
