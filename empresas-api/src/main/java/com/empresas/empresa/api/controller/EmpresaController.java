package com.empresas.empresa.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.empresas.empresa.api.model.EmpresaInput;
import com.empresas.empresa.api.model.EmpresaModel;
import com.empresas.empresa.domain.model.Empresa;
import com.empresas.empresa.domain.repository.EmpresaRepository;
import com.empresas.empresa.domain.service.CadastroEmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
    private EmpresaRepository empresaRepository;
	
	@Autowired
	private CadastroEmpresaService cadastroEmpresa;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<EmpresaModel> listar() {
		return toCollectionModel(empresaRepository.findAll());
	}

	@GetMapping("/{empresaId}")
	public ResponseEntity<EmpresaModel> buscar(@PathVariable Long empresaId) {
		Optional<Empresa> empresa = empresaRepository.findById(empresaId);
		
		if (empresa.isPresent()) {
			EmpresaModel empresaModel = toModel(empresa.get());
			return ResponseEntity.ok(empresaModel);
		}
		
		return ResponseEntity.notFound().build();
		
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EmpresaModel criar(@Valid @RequestBody EmpresaInput empresaInput) {
		Empresa empresa = toEntity(empresaInput);
		
		return toModel(cadastroEmpresa.salvar(empresa));
	}
	
	private EmpresaModel toModel(Empresa empresa) {
		return modelMapper.map(empresa, EmpresaModel.class);
	}
	
	private List<EmpresaModel> toCollectionModel(List<Empresa> empresas) {
		return empresas.stream().map(empresa -> toModel(empresa)).collect(Collectors.toList());
	}

	private Empresa toEntity(EmpresaInput empresaInput) {
		return modelMapper.map(empresaInput, Empresa.class);
	} 

}
