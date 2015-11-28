package io.cj.portfolio.jpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//标签
@Entity
public class Label implements Serializable {

	private static final long serialVersionUID = 1L;

	public Label() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//	名字
	@Column(nullable = false)
	private String name;

	//登录用户ID
	@Column
	private Long loginUserID;

	//	父标签
	@ManyToOne
	@JoinColumn(name = "parentid")
	@JsonBackReference // this annotation prevents the exception
	private Label parent;

	//	子标签集合
	@OneToMany(
			mappedBy = "parent",
			fetch = FetchType.LAZY
			)
	@JsonManagedReference // this annotation prevents the exception
	private List<Label> children;

	//	用于和基金基本情报关联
//	@ManyToMany(
//			targetEntity = io.cj.portfolio.jpa.model.Portfolio.class,
//			cascade = CascadeType.ALL,
//			fetch = FetchType.LAZY)
//	@JoinTable(
//			name = "LabelPortfolio",
//			joinColumns = { @JoinColumn(name = "labelid") },
//			inverseJoinColumns = {
//					@JoinColumn(name = "portfolioid") }
//			)
//	@ManyToMany(mappedBy="labels")
//	@JsonBackReference // this annotation prevents the exception
//	private List<Portfolio> portfolios;

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

	public Long getLoginUserID() {
		return loginUserID;
	}

	public void setLoginUserID(Long loginUserID) {
		this.loginUserID = loginUserID;
	}

	public Label getParent() {
		return parent;
	}

	public void setParent(Label parent) {
		this.parent = parent;
	}

	public List<Label> getChildren() {
		return children;
	}

	public void setChildren(List<Label> children) {
		this.children = children;
	}
}
