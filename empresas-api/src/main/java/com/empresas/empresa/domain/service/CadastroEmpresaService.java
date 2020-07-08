package com.empresas.empresa.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresas.empresa.domain.exception.NegocioException;
import com.empresas.empresa.domain.model.Empresa;
import com.empresas.empresa.domain.repository.EmpresaRepository;

@Service
@RequestMapping("clientes/{clienteId}")
public class CadastroEmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa salvar(Empresa empresa) {
		Empresa empresaExiste = empresaRepository.findByEmail(empresa.getEmail());
		
		if (empresaExiste != null && !empresaExiste.equals(empresa)) {
			throw new NegocioException("Já existe uma empresa cadastrado com este e-mail.");
		}
		
		return empresaRepository.save(empresa);
	}
	 
	

}
