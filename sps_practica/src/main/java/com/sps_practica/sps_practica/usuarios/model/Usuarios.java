package com.sps_practica.sps_practica.usuarios.model;

import java.util.Date;

public class Usuarios {

	private String name;
	private String firstLastName;
	private String lastName;
	private Date date;

	Usuarios() {

	}

	public Usuarios(String name, String firstLastName, String lastName, Date date) {
		super();
		this.name = name;
		this.firstLastName = firstLastName;
		this.lastName = lastName;
		this.date = date;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstLastName() {
		return firstLastName;
	}


	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Usuarios [name=" + name + ", firstLastName=" + firstLastName + ", lastName=" + lastName + ", date="
				+ date + "]";
	}


}
