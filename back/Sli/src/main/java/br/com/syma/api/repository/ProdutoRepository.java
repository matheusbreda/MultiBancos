package br.com.syma.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.syma.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String>{

}
