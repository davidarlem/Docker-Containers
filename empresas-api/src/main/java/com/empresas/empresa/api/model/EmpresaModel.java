package com.empresas.empresa.api.model;

import java.time.OffsetDateTime;

public class EmpresaModel {

	private Long id;
//	private ClienteResumoModel cliente;
	private String nomeEmpresa;
	private OffsetDateTime dataEntrada;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public OffsetDateTime getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(OffsetDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	
}
