package com.sps_practica.sps_practica.common;

import org.springframework.stereotype.Component;

@Component
public class Response {

	private String idResponse;
	private String description;

	Response() {

	}

	public Response (String idResponse, String description) {
		super();
		this.idResponse = idResponse;
		this.description = description;
	}

	public String getIdResponse() {
		return idResponse;
	}

	public void setIdResponse(String idResponse) {
		this.idResponse = idResponse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Response getResponse(String idResponse, String description) {
		return new Response(idResponse, description);
	}

	@Override
	public String toString() {
		return "Response [idResponse=" + idResponse + ", description=" + description + "]";
	}

}
