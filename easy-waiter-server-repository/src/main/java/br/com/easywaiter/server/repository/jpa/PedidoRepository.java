package br.com.easywaiter.server.repository.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easywaiter.server.repository.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
