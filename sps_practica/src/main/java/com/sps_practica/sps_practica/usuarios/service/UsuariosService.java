package com.sps_practica.sps_practica.usuarios.service;

import java.io.IOException;

import com.sps_practica.sps_practica.common.Response;
import com.sps_practica.sps_practica.usuarios.model.Usuarios;
import com.sps_practica.sps_practica.usuarios.model.UsuariosResponse;

public interface UsuariosService {

	Response createUsuario(Usuarios usuario) throws IOException;

	Response updateUsuario(String idUsuario, Usuarios usuario) throws IOException;

	Response deleteUsuario(String idUsuario) throws IOException;

	UsuariosResponse searchByName(String id) throws IOException;

}
