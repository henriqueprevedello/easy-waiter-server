package br.com.easywaiter.server.repository.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easywaiter.server.repository.domain.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {

	Optional<Comanda> findByCodigoEstabelecimentoAndCodigoClienteAndDataFechamentoIsNull(Long codigoEstabelecimento,
			Long codigoCliente);

	List<Comanda> findByCodigoEstabelecimento(Long codigoEstabelecimento);

	Optional<Comanda> findFirstByCodigoClienteAndDataFechamentoIsNull(Long codigoCliente);

}
