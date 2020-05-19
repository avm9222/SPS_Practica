package com.sps_practica.sps_practica.index.serviceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps_practica.sps_practica.common.Response;
import com.sps_practica.sps_practica.index.model.Indexes;
import com.sps_practica.sps_practica.index.service.ServiceIndex;

@Service
public class ServiceIndexImpl implements ServiceIndex {

	@Autowired
	private RestHighLevelClient client;

	@Autowired
	Response response;

	@Override
	public Response createIndex(Indexes index) throws IOException {
		
		if (index.getIndexName().length() < 0 && index.getReplicas() < 1 && index.getSharps() < 1) {
			return response.getResponse(index.getIndexName() + " please validate request ", "Created: " + false);
		}

		CreateIndexRequest request = new CreateIndexRequest(index.getIndexName().toLowerCase());
		request.settings(Settings.builder().put("index.number_of_shards", index.getSharps())
				.put("index.number_of_replicas", index.getReplicas()));

		Map<String, Object> message = new HashMap<>();
		message.put("type", "text");

		Map<String, Object> keyWordMap = new HashMap<>();
		Map<String, Object> keyWordValueMap = new HashMap<>();
		keyWordValueMap.put("type", "keyword");
		keyWordValueMap.put("ignore_above", 256);
		keyWordMap.put("keyword", keyWordValueMap);
		message.put("fields", keyWordMap);

		Map<String, Object> properties = new HashMap<>();
		properties.put("userId", message);
		properties.put("name", message);

		Map<String, Object> mapping = new HashMap<>();
		mapping.put("properties", properties);
		request.mapping(mapping);

		try {
			GetIndexRequest getIndexRequest = new GetIndexRequest(index.getIndexName().toLowerCase());
			boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
			if (!exists) {
				CreateIndexResponse indexResponse = client.indices().create(request, RequestOptions.DEFAULT);
				return response.getResponse(indexResponse.index().toString(),
						"Created: " + indexResponse.isAcknowledged());

			} else {
				return response.getResponse("Index: " + index.getIndexName() + ". Already exist", "Created: " + false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response.getResponse(index.getIndexName(), "Created: " + false);
	}
}
