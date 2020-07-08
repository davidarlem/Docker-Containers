package com.containers.container.api.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClientesInput {

	@NotBlank
	@NotNull
	private String nome;

	@NotBlank
	@NotNull
	private String email;

	@Valid
	@NotBlank
	@NotNull
	private String cpf;

	@NotBlank
	@NotNull
	private String telefone;
	
//	private EmpresasInput empresa;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
