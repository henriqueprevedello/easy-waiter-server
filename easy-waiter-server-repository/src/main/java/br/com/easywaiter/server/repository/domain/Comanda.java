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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_comanda")
public class Comanda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comanda", nullable = false)
	private Long id;

	@Column(name = "cd_mesa", nullable = false)
	private Long codigoMesa;

	@OneToOne
	@JoinColumn(name = "cd_mesa", referencedColumnName = "id_mesa", nullable = false, insertable = false, updatable = false)
	private Mesa mesa;

	@Column(name = "cd_cliente", nullable = false)
	private Long codigoCliente;

	@ManyToOne
	@JoinColumn(name = "cd_cliente", referencedColumnName = "cd_usuario", nullable = false, insertable = false, updatable = false)
	private Cliente cliente;

	@Column(name = "cd_estabelecimento", nullable = false)
	private Long codigoEstabelecimento;

	@ManyToOne
	@JoinColumn(name = "cd_estabelecimento", referencedColumnName = "cd_usuario", nullable = false, insertable = false, updatable = false)
	private Estabelecimento estabelecimento;

	@OneToMany(mappedBy = "comanda")
	private List<Pedido> pedidos = new ArrayList<>();

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date dataAbertura;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dataFechamento;

}
