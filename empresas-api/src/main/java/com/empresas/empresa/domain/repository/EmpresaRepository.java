package com.empresas.empresa.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresas.empresa.domain.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	List<Empresa> findByNomeEmpresa(String nomeEmpresa);
	List<Empresa> findByNomeEmpresaContaining(String nomeEmpresa);
	List<Empresa> findByCnpj(String cnpj);
	List<Empresa> findByTelefone(String telefone);
	Empresa findByEmail(String email);
}
