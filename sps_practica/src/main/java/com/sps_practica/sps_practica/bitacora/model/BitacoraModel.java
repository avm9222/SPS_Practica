package com.sps_practica.sps_practica.bitacora.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public class BitacoraModel {

	@NotNull
	@NotBlank
	@Schema(required = true)
	private UsurioModel usuarioModel;
	@NotNull
	@NotBlank
	@Schema(required = true)
	private List<PromocionesModel> promocionesModel;

	BitacoraModel() {

	}

	public BitacoraModel(UsurioModel usuarioModel, List<PromocionesModel> promocionesModel) {
		super();
		this.usuarioModel = usuarioModel;
		this.promocionesModel = promocionesModel;
	}

	public UsurioModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(UsurioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}

	public List<PromocionesModel> getPromocionesModel() {
		return promocionesModel;
	}

	public void setPromocionesModel(List<PromocionesModel> promocionesModel) {
		this.promocionesModel = promocionesModel;
	}

	@Override
	public String toString() {
		return "BitacoraModel [usuarioModel=" + usuarioModel + ", promocionesModel=" + promocionesModel + "]";
	}



}
