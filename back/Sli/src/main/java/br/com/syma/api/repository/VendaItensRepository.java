package br.com.syma.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.syma.api.model.VendaItens;

public interface VendaItensRepository extends JpaRepository<VendaItens, Integer>  {

}
