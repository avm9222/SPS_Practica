package com.sps_practica.sps_practica.bitacora.serviceImpl;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sps_practica.sps_practica.bitacora.model.BitacoraModel;
import com.sps_practica.sps_practica.bitacora.service.BitacoraService;
import com.sps_practica.sps_practica.common.Response;

@Service
public class BitacoraServiceImpl implements BitacoraService {

	@Autowired
	private RestHighLevelClient client;

	@Autowired
	Response response;

	@Override
	public Response createBitacora(BitacoraModel bitacoraModel) throws IOException {
		IndexRequest request = new IndexRequest("bitacora");
		request.source(new ObjectMapper().writeValueAsString(bitacoraModel), XContentType.JSON);
		IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
		System.out.println(indexResponse.getResult());

		if (indexResponse.getId() != null) {
			return response.getResponse(indexResponse.getId(),
					"Bitacora: " + HttpStatus.SC_CREATED + " "
							+ indexResponse.status().toString());
		} else {
			return response.getResponse(indexResponse.status().toString(),
					"User: " + indexResponse.getResult().name() + " Not Created.");
		}
	}

}
