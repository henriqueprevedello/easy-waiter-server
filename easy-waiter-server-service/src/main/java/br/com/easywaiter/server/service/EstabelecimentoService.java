package br.com.easywaiter.server.service;

import java.util.List;

import br.com.easywaiter.server.util.dto.EstabelecimentoDTO;
import br.com.easywaiter.server.util.dto.LocalizacaoDTO;

public interface EstabelecimentoService {

	EstabelecimentoDTO editar(EstabelecimentoDTO estabelecimentoDTO) throws Exception;

	EstabelecimentoDTO adquirir(Long codigoEstabelecimento);

	List<LocalizacaoDTO> adquirirLocalizacoes();

	List<EstabelecimentoDTO> adquirirPorLocalizacao(String cidade, String estado);

}
