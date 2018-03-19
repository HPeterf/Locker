package com.locker.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity(name = "Lockers")
@Table(name = "Lockers")
public class Locker implements Serializable {

	private static final long serialVersionUID = 2335980805649334694L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	// @NotNull
	@Column(name = "number", unique = true)
	@Min(1)
	private Long number;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Locker() {

	}

	public Locker(Long number) {
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Locker [number=" + number + "]";
	}

}
