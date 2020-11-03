package br.com.easywaiter.server.repository.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_pedidoitem")
public class PedidoItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cd_pedido", nullable = false)
	private Long codigoPedido;

	@ManyToOne
	@JoinColumn(name = "cd_pedido", referencedColumnName = "id_pedido", nullable = false, insertable = false, updatable = false)
	private Pedido pedido;

	@Column(name = "cd_produto", nullable = false)
	private Long codigoProduto;

	@ManyToOne
	@JoinColumn(name = "cd_produto", referencedColumnName = "id_produto", nullable = false, insertable = false, updatable = false)
	private Produto produto;

	private Long quantidade;

}