package br.com.easywaiter.server.repository.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_mesa")
public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mesa", nullable = false)
	private Long id;

	private Long numero;

	private Boolean ocupado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_exclusao")
	private Date dataExclusao;

	@Column(name = "cd_estabelecimento", nullable = false)
	private Long codigoEstabelecimento;

	@ManyToOne
	@JoinColumn(name = "cd_estabelecimento", referencedColumnName = "cd_usuario", nullable = false, insertable = false, updatable = false)
	private Estabelecimento estabelecimento;

}