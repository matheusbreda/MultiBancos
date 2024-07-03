package br.com.syma.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.syma.api.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, String> {

}
