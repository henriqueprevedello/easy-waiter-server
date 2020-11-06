package br.com.easywaiter.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easywaiter.server.repository.domain.Categoria;
import br.com.easywaiter.server.repository.jpa.CategoriaRepository;
import br.com.easywaiter.server.service.CategoriaService;
import br.com.easywaiter.server.util.dto.CategoriaDTO;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void cadastrar(CategoriaDTO categoriaDTO, Long codigoEstabelecimento) {

		Categoria categoria = new Categoria();
		categoria.setCodigoEstabelecimento(codigoEstabelecimento);
		categoria.setNome(categoriaDTO.getNome());

		categoriaRepository.save(categoria);

	}

}
