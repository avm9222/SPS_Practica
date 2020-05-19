package com.sps_practica.sps_practica.bitacora.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

public class UsurioModel {

	@Schema(required = true)
	private String usuarioId;
	private Date modifiDate;

	UsurioModel() {
		
	}

	public UsurioModel(String usuarioId, Date modifyDate) {
		super();
		this.usuarioId = usuarioId;
		this.modifiDate = modifyDate;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Date getModifiDate() {
		return modifiDate;
	}

	public void setModifiDate(Date modifiDate) {
		this.modifiDate = modifiDate;
	}

	@Override
	public String toString() {
		return "UsurioModel [usuarioId=" + usuarioId + ", modifiDate=" + modifiDate + "]";
	}

}
