package br.com.easywaiter.server.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easywaiter.server.repository.domain.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

}
