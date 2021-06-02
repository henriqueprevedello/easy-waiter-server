package br.com.easywaiter.server.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.easywaiter.server.repository.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	List<Categoria> findByCodigoEstabelecimentoAndDataExclusaoIsNullOrderByIdDesc(Long codigoEstabelecimento);

	@Query("SELECT c FROM tb_categoria c INNER JOIN tb_produto p ON p.codigoCategoria = c.id WHERE c.codigoEstabelecimento = ?1 AND p.dataExclusao IS NULL GROUP BY c.id")
	List<Categoria> adquirirCategoriasEProdutosDisponiveis(Long codigoEstabelecimento);
}
