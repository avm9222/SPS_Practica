package com.sps_practica.sps_practica.index.service;

import java.io.IOException;

import com.sps_practica.sps_practica.common.Response;
import com.sps_practica.sps_practica.index.model.Indexes;


public interface ServiceIndex {

	Response createIndex(Indexes index) throws IOException;

}
