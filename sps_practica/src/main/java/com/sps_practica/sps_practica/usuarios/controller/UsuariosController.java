package com.sps_practica.sps_practica.usuarios.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sps_practica.sps_practica.common.Response;
import com.sps_practica.sps_practica.usuarios.model.Usuarios;
import com.sps_practica.sps_practica.usuarios.model.UsuariosResponse;
import com.sps_practica.sps_practica.usuarios.service.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	UsuariosService usuariosService;

	@Autowired
	UsuariosResponse usuariosResponse;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Response saveUsuario(@RequestBody Usuarios usuario) throws IOException {
		return usuariosService.createUsuario(usuario);
	}

	@GetMapping("/search/{id}")
	public UsuariosResponse searchByName(@PathVariable final String id) throws IOException {
		return usuariosService.searchByName(id);
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
	public Response update(@PathVariable String id, @Valid @RequestBody Usuarios usuario) throws IOException {
		return usuariosService.updateUsuario(id, usuario);
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public Response deleteUser(@PathVariable String id) throws IOException {
		return usuariosService.deleteUsuario(id);
	}

}
