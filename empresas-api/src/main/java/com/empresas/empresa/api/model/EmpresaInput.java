package com.empresas.empresa.api.model;

import javax.validation.constraints.NotBlank;

public class EmpresaInput {

	@NotBlank
	private String nomeEmpresa;
	
//	private ClienteInput cliente;

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	
}
