package br.com.easywaiter.server.repository.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_produto")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto", nullable = false)
	private Long id;

	private String nome;

	private String descricao;

	@Column(name = "tx_nomeimagem")
	private String nomeImagem;

	private BigDecimal valor;

	private boolean ativo;

	@Lob
	private byte[] imagem;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_exclusao")
	private Date dataExclusao;

	@Column(name = "cd_estabelecimento", nullable = false)
	private Long codigoEstabelecimento;

	@ManyToOne
	@JoinColumn(name = "cd_estabelecimento", referencedColumnName = "cd_usuario", nullable = false, insertable = false, updatable = false)
	private Estabelecimento estabelecimento;

	@Column(name = "cd_categoria", nullable = false)
	private Long codigoCategoria;

	@ManyToOne
	@JoinColumn(name = "cd_categoria", referencedColumnName = "id_categoria", nullable = false, insertable = false, updatable = false)
	private Categoria categoria;

}
