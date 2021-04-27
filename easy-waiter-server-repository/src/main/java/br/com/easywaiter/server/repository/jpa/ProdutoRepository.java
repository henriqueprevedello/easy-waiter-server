package br.com.easywaiter.server.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easywaiter.server.repository.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findAllByCodigoEstabelecimentoAndDataExclusaoIsNullOrderByIdDesc(Long codigoEstabelecimento);

	List<Produto> findAllByCodigoEstabelecimentoAndDataExclusaoIsNullAndAtivoIsTrueOrderByIdDesc(
			Long codigoEstabelecimento);

	Integer countByCodigoCategoriaAndDataExclusaoIsNullAndAtivoIsTrue(Long codigoCategoria);

}
