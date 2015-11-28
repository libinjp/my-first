package io.cj.portfolio.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dept{

	public Dept() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//	@OneToMany(mappedBy = "dept" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JsonManagedReference // this annotation prevents the exception
//	private Set<LoginUser> loginUser;

	@Column(nullable = false)
	private String name;

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

}
