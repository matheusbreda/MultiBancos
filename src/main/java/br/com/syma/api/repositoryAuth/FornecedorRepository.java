package br.com.syma.api.repositoryAuth;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.syma.api.modelAuth.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{

}
