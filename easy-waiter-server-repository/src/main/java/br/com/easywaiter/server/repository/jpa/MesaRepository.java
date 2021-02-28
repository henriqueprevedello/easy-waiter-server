package br.com.easywaiter.server.repository.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easywaiter.server.repository.domain.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Long> {

	List<Mesa> findByCodigoEstabelecimentoAndDataExclusaoIsNullOrderByNumeroAsc(Long codigoEstabelecimento);

	Optional<Mesa> findFirstByNumero(Long numero);

}
