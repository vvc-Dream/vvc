package com.sc.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="users", catalog="bus_analy")
public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String name) {
		this.name = name;
	}

	/** full constructor */
	public Users(String name, String password) {
		this.name = name;
		this.password = password;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="id",unique=true,nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}