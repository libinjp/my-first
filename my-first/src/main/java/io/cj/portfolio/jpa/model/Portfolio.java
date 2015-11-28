package io.cj.portfolio.jpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Portfolio {

	public Portfolio(){
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

    @ManyToMany(
    		targetEntity= io.cj.portfolio.jpa.model.Label.class,
    		cascade=CascadeType.ALL,
    		fetch=FetchType.LAZY
    )
    @JoinTable(
    	name="LabelPortfolio",
        joinColumns={@JoinColumn(name="portfolioid")},
        inverseJoinColumns={@JoinColumn(name="labelid")}
    )
    @JsonBackReference // this annotation prevents the exception
	private List<Label> labels;

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

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

}
