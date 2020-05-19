package com.sps_practica.sps_practica.usuarios.model;

import org.springframework.stereotype.Controller;

import com.sps_practica.sps_practica.common.Response;

@Controller
public class UsuariosResponse {

	private Response response;

	private String name;
	private String firstLastName;
	private String lastName;

	UsuariosResponse() {

	}

	public UsuariosResponse(Response response, String name, String firstLastName, String lastName) {
		super();
		this.response = response;
		this.name = name;
		this.firstLastName = firstLastName;
		this.lastName = lastName;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
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

	public UsuariosResponse getUsuariosResponse(Response response, String name, String firstLastName, String lastName) {
		return new UsuariosResponse(response, name, firstLastName, lastName);
	}

}
