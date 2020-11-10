package br.com.easywaiter.server.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easywaiter.server.repository.domain.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Long> {

	List<Mesa> findByCodigoEstabelecimento(Long codigoEstabelecimento);

}
