package br.com.easywaiter.server.repository.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_estabelecimento")
public class Estabelecimento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cd_usuario", nullable = false)
	private Long codigoUsuario;

    @OneToOne
    @JoinColumn(name = "cd_usuario", referencedColumnName = "id_usuario", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;

	private String descricao;

	private String numeroTelefone;

	private String cnpj;

	@Lob
	private byte[] imagem;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Produto> produtos = new ArrayList<>();

}