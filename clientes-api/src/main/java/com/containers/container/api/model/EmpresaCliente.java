package com.containers.container.api.model;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.containers.container.domain.model.Clientes;

@Component
public class EmpresaCliente {

	public Clientes buscarCliente(Long id) {
		RestTemplate template = new RestTemplate();
		
		return template.getForObject("localhost:8080/empresa", Clientes.class, id);
	}
}
