package com.sc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Input entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="input",catalog="bus_analy")
public class Input implements java.io.Serializable {

	// Fields

	private Integer id;
	private String good;
	private String code;
	private Integer count;
	private Float price;
	private Float rat;
	private Float incomeVat;
	private Date time;

	// Constructors

	/** default constructor */
	public Input() {
	}

	/** full constructor */
	public Input(String good, String code, Integer count, Float price,
			Float rat, Float incomeVat, Date time) {
		this.good = good;
		this.code = code;
		this.count = count;
		this.price = price;
		this.rat = rat;
		this.incomeVat = incomeVat;
		this.time = time;
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
	@Column(name="good")
	public String getGood() {
		return this.good;
	}

	public void setGood(String good) {
		this.good = good;
	}
	@Column(name="code")
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name="price")
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	@Column(name="rat")
	public Float getRat() {
		return this.rat;
	}

	public void setRat(Float rat) {
		this.rat = rat;
	}
	@Column(name="IncomeVat")
	public Float getIncomeVat() {
		return this.incomeVat;
	}

	public void setIncomeVat(Float incomeVat) {
		this.incomeVat = incomeVat;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="time", length=10)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}