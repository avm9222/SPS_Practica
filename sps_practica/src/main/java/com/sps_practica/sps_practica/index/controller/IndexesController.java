package com.sps_practica.sps_practica.index.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sps_practica.sps_practica.common.Response;
import com.sps_practica.sps_practica.index.model.Indexes;
import com.sps_practica.sps_practica.index.service.ServiceIndex;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/Index")
public class IndexesController {

	@Autowired
	ServiceIndex serviceIndex;

	@Operation(summary = "Servicio para crear el Indice en ElasticSearch", description = "Todos los campos son requeridos: "
			+ "indexName: nombre del index a generar. " + "replicas: Numero de replicas que se requiere al index. "
			+ "sharps: numero de sharps que se requieren. ")
	@RequestMapping(value = "/createIndex", method = RequestMethod.POST)
	public Response createIndex(@Valid @RequestBody Indexes indexes) throws IOException {
		return serviceIndex.createIndex(indexes);
	}
	
}
