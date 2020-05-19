package com.sps_practica.sps_practica.bitacora.model;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

public class PromocionesModel {

	@Schema(required = true)
	@NotBlank
	private String idPromotion;
	@Schema(required = true)
	@NotBlank
	private String oldPromotion;
	@Schema(required = true)
	@NotBlank
	private String newPromotion;

	PromocionesModel() {

	}

	public PromocionesModel(String idPromotion, String oldPromotion, String newPromotion) {
		super();
		this.idPromotion = idPromotion;
		this.oldPromotion = oldPromotion;
		this.newPromotion = newPromotion;
	}

	public String getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(String idPromotion) {
		this.idPromotion = idPromotion;
	}

	public String getOldPromotion() {
		return oldPromotion;
	}

	public void setOldPromotion(String oldPromotion) {
		this.oldPromotion = oldPromotion;
	}

	public String getNewPromotion() {
		return newPromotion;
	}

	public void setNewPromotion(String newPromotion) {
		this.newPromotion = newPromotion;
	}

	@Override
	public String toString() {
		return "PromocionesModel [idPromotion=" + idPromotion + ", oldPromotion=" + oldPromotion + ", newPromotion="
				+ newPromotion + "]";
	}

}
