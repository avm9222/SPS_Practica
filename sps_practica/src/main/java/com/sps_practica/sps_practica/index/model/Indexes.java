package com.sps_practica.sps_practica.index.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class Indexes {

	@Schema(required = true)
	private String indexName;
	@Schema(required = true)
	private int replicas;
	@Schema(required = true)
	private int sharps;


	Indexes() {

	}

	public Indexes(String indexName, int replicas, int sharps) {
		super();
		this.indexName = indexName;
		this.replicas = replicas;
		this.sharps = sharps;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public int getReplicas() {
		return replicas;
	}

	public void setReplicas(int replicas) {
		this.replicas = replicas;
	}

	public int getSharps() {
		return sharps;
	}

	public void setSharps(int sharps) {
		this.sharps = sharps;
	}


}