package com.sps_practica.sps_practica.bitacora.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sps_practica.sps_practica.bitacora.model.BitacoraModel;
import com.sps_practica.sps_practica.bitacora.service.BitacoraService;
import com.sps_practica.sps_practica.common.Response;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("Bitacora")
public class BitacoraController {

	@Autowired
	BitacoraService bitacoraService;

	@Operation(summary = "Crea documento en el indice bitacora", description = "Se envia el objeto usuarioModel para identidica el usuario que esta haciedo la modificacion sobre la promocion, "
			+ "Se requiere el objeto promocionesModel en donde se especifica el id de la promocion actual (idPromotion),"
			+ " la descripcion de la promocion actual (oldPromotion) y nueva promocion (newPromotion)."
			+ "Todos los campos son requeridos.")
	@RequestMapping(value = "/createBitacora", method = RequestMethod.POST)
	public Response createBitacora(@Valid @RequestBody BitacoraModel bitacoraModel) throws IOException {
		return bitacoraService.createBitacora(bitacoraModel);
	}

}
