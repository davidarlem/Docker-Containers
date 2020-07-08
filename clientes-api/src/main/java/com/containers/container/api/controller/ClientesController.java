package com.containers.container.api.controller;

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

import com.containers.container.api.model.ClientesInput;
import com.containers.container.api.model.ClientesModel;
import com.containers.container.domain.model.Clientes;
import com.containers.container.domain.repository.ClientesRepository;
import com.containers.container.domain.service.CadastroClientesService;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
    private ClientesRepository clienteRepository;
	
	@Autowired
	private CadastroClientesService cadastroCliente;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClientesModel criar(@Valid @RequestBody ClientesInput clienteInput) {
		Clientes cliente = toEntity(clienteInput);
		
		return toModel(cadastroCliente.salvar(cliente));
	}

	@GetMapping
	public List<ClientesModel> listar() {
		return toCollectionModel(clienteRepository.findAll());
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<ClientesModel> buscar(@PathVariable Long clienteId) {
		Optional<Clientes> cliente = clienteRepository.findById(clienteId);
		
		if (cliente.isPresent()) {
			ClientesModel clienteModel = toModel(cliente.get());
			return ResponseEntity.ok(clienteModel);
		}
		
		return ResponseEntity.notFound().build();
		
	}

	
	private ClientesModel toModel(Clientes cliente) {
		return modelMapper.map(cliente, ClientesModel.class);
	}
	
	private List<ClientesModel> toCollectionModel(List<Clientes> clientes) {
		return clientes.stream().map(cliente -> toModel(cliente)).collect(Collectors.toList());
	}

	private Clientes toEntity(ClientesInput clienteInput) {
		return modelMapper.map(clienteInput, Clientes.class);
	}

}
