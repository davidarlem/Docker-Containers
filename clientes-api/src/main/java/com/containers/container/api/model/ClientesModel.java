package com.containers.container.api.model;

import org.springframework.stereotype.Component;

@Component
public class ClientesModel {
	
	private Long id;
//	private EmpresasResumoModel empresa;
	private String nome;
	private String email;
	private String telefone;
//	private OffsetDateTime dataEntrada;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	

}
