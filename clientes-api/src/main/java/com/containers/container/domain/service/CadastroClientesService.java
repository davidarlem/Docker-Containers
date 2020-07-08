package com.containers.container.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.containers.container.domain.exception.NegocioException;
import com.containers.container.domain.model.Clientes;
import com.containers.container.domain.repository.ClientesRepository;

@Service
public class CadastroClientesService {

//	@Autowired
//	private EmpresasRepository empresaRepository;	

	@Autowired
	private ClientesRepository clienteRepository;
/*
	public Clientes criar(Clientes cliente) {
		Empresas empresa = empresaRepository.findById(cliente.getEmpresa().getId())
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente não encontrado")); 

		cliente.setEmpresa(empresa);
//		cliente.setEmail(email);
//		cliente.setNome(nome);
//		cliente.setTelefone(telefone);
//		cliente.setCpf(cpf);
		
		return clienteRepository.save(cliente);
	}
*/	
	public void finalizar(Long clienteId) {
		Clientes cliente = buscar(clienteId);
		
		clienteRepository.save(cliente);
	}

	private Clientes buscar(Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new NegocioException("Empresa não encontrada"));
	}

	public Clientes salvar(Clientes cliente) {
		Clientes clienteExiste = clienteRepository.findByEmail(cliente.getEmail());
		
		if (clienteExiste != null && !clienteExiste.equals(cliente)) {
			throw new NegocioException("Já existe uma empresa cadastrado com este e-mail.");
		}

		return clienteRepository.save(cliente);
	}
	
}
