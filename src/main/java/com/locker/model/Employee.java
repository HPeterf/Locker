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

import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "Employees")
@Table(name = "Employees")
public class Employee implements Serializable {

	private static final long serialVersionUID = 8011138318793727789L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	// @NotNull
	@NotBlank
	@Column(name = "name", unique = true)
	private String name;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Locker locker;

	public Locker getLocker() {
		return locker;
	}

	public void setLocker(Locker locker) {
		this.locker = locker;
	}

	public Employee() {

	}

	public Employee(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employees [name=" + name + "]";
	}

}
