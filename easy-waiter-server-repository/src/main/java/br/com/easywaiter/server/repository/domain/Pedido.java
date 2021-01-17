package br.com.easywaiter.server.repository.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido", nullable = false)
	private Long id;

	@Column(name = "cd_comanda")
	private Long codigoComanda;

	@ManyToOne
	@JoinColumn(name = "cd_comanda", referencedColumnName = "id_comanda", nullable = false, insertable = false, updatable = false)
	private Comanda comanda;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date dataCadastro;

	@OneToMany(mappedBy = "pedido")
	private List<PedidoItem> pedidoItens = new ArrayList<>();

	@Column(name = "cd_status")
	private Long codigoStatus;
}
