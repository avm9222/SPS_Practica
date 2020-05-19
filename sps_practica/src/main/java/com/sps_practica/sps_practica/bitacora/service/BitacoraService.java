package com.sps_practica.sps_practica.bitacora.service;

import java.io.IOException;

import com.sps_practica.sps_practica.bitacora.model.BitacoraModel;
import com.sps_practica.sps_practica.common.Response;


public interface BitacoraService {
	
	Response createBitacora(BitacoraModel bitacoraModel) throws IOException;

}
