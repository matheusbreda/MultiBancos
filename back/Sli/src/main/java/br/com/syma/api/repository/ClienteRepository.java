package br.com.syma.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.syma.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
