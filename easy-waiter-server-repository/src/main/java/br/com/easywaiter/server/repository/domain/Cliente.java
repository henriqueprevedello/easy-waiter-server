package br.com.easywaiter.server.repository.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cd_usuario", nullable = false)
	private Long codigoCliente;

	@OneToOne
	@JoinColumn(name = "cd_usuario", referencedColumnName = "id_usuario", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;

}
