package br.com.easywaiter.server.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easywaiter.server.repository.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findAllByCodigoEstabelecimentoAndDataExclusaoIsNullOrderByIdDesc(Long codigoEstabelecimento);

	Integer countByCodigoCategoriaAndDataExclusaoIsNull(Long codigoCategoria);

}
