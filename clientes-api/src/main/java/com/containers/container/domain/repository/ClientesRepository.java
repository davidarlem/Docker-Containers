package com.containers.container.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.containers.container.domain.model.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long>{
	
	List<Clientes> findByNome(String nome);
	List<Clientes> findByNomeContaining(String nome);
	Clientes findByEmail(String email);

	
}
