package br.com.easywaiter.server.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

import br.com.easywaiter.server.repository.domain.Categoria;
import br.com.easywaiter.server.repository.jpa.CategoriaRepository;
import br.com.easywaiter.server.service.CategoriaService;
import br.com.easywaiter.server.util.dto.CategoriaDTO;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void cadastrar(CategoriaDTO categoriaDTO, Long codigoEstabelecimento) {

		Categoria categoria = new Categoria();
		categoria.setCodigoEstabelecimento(codigoEstabelecimento);
		categoria.setNome(categoriaDTO.getNome());

		categoriaRepository.save(categoria);

	}

	@Override
	public List<CategoriaDTO> adquirirPorEstabelecimento(Long codigoEstabelecimento) {

		return modelMapper.map(categoriaRepository.findByCodigoEstabelecimento(codigoEstabelecimento),
				TypeToken.getParameterized(List.class, CategoriaDTO.class).getType());
	}

	@Override
	public void editar(CategoriaDTO categoriaDTO) throws Exception {

		Optional<Categoria> optionalCategoria = categoriaRepository.findById(categoriaDTO.getId());

		if (!optionalCategoria.isPresent()) {
			throw new Exception("Categoria não encontrada");
		}

		Categoria categoria = optionalCategoria.get();
		categoria.setNome(categoriaDTO.getNome());

		categoriaRepository.save(categoria);
	}

}
