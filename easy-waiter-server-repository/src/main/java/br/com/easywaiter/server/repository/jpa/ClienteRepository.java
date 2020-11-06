package br.com.easywaiter.server.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easywaiter.server.repository.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
