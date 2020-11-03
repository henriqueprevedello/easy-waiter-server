package br.com.easywaiter.server.repository.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easywaiter.server.repository.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
