package br.com.easywaiter.server.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.easywaiter.server.repository.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Query("SELECT p FROM tb_pedido p LEFT JOIN tb_comanda c ON p.codigoComanda = c.id WHERE c.codigoEstabelecimento = ?1 AND p.codigoStatus NOT IN (0, 1, 6) ORDER BY p.dataCadastro DESC")
	List<Pedido> adquirirNaoFinalizadosPorCodigoEstabelecimento(Long codigoEstabelecimento);

	@Query("SELECT p FROM tb_pedido p LEFT JOIN tb_comanda c ON p.codigoComanda = c.id WHERE c.codigoCliente = ?1 AND c.dataFechamento IS NULL ORDER BY p.dataCadastro DESC")
	List<Pedido> adquirirTodosPorCodigoClienteEmComandaAberta(Long codigoCliente);

}
