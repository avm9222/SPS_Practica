package com.sps_practica.sps_practica.usuarios.serviceImpl;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sps_practica.sps_practica.common.Response;
import com.sps_practica.sps_practica.usuarios.model.Usuarios;
import com.sps_practica.sps_practica.usuarios.model.UsuariosResponse;
import com.sps_practica.sps_practica.usuarios.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {

	@Autowired
	private RestHighLevelClient client;

	@Autowired
	Response response;

	@Autowired
	UsuariosResponse usuariosResponse;

	@Override
	public Response createUsuario(Usuarios usuario) throws IOException {
		IndexRequest request = new IndexRequest("usuarios");
		request.source(new ObjectMapper().writeValueAsString(usuario), XContentType.JSON);
		IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
		System.out.println(indexResponse.getResult());

		if (indexResponse.getId() != null) {
			return response.getResponse(
					indexResponse.getId(), "User: " + usuario.getName() + " " + indexResponse.status().toString());
		} else {
			return response.getResponse(indexResponse.status().toString(),
					"User: " + indexResponse.getResult().name() + " Not Created.");
		}

	}


	@Override
	public UsuariosResponse searchByName(String id) throws IOException {
		GetRequest getRequest = new GetRequest("usuarios", id);
		getRequest.routing("id");

		GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
		if (getResponse.isExists()) {

			Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
			return usuariosResponse.getUsuariosResponse(
					response.getResponse("id: " + getResponse.getId() + " Index: " + getResponse.getIndex(),
							"found: " + getResponse.isExists()),
					sourceAsMap.get("name").toString(), sourceAsMap.get("firstLastName").toString(),
					sourceAsMap.get("lastName").toString());
			
		}else {
			return usuariosResponse.getUsuariosResponse(
					response.getResponse(String.valueOf(HttpStatus.SC_NOT_FOUND), "_docNotFound"),
					null, null, null);
		}

	}

	@Override
	public Response updateUsuario(String idUsuario, Usuarios usuario) throws IOException {
		UpdateRequest updateRequest = new UpdateRequest("usuarios", idUsuario);
		updateRequest.doc(new ObjectMapper().writeValueAsString(usuario), XContentType.JSON);

		UpdateResponse updateResponse;
		try {
			updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
			return response.getResponse(String.valueOf(updateResponse.status()), "Updated OK/ " + updateResponse.status());
		} catch (Exception e) {
			e.printStackTrace();
			return response.getResponse(String.valueOf(HttpStatus.SC_NOT_MODIFIED), "Not Updated / " + e);
		}

		
	}

	@Override
	public Response deleteUsuario(String idUsuario) throws IOException {
		DeleteRequest request = new DeleteRequest("usuarios", idUsuario);
		
		
		try {
			DeleteResponse deleteResponse = client.delete(request, RequestOptions.DEFAULT);
			
			return response.getResponse(String.valueOf(deleteResponse.status()), "Document deleted");
		} catch (Exception e) {
			e.printStackTrace();
			return response.getResponse(String.valueOf(HttpStatus.SC_NOT_FOUND), "id: " + idUsuario + ": not found.");
		}
	}


}
