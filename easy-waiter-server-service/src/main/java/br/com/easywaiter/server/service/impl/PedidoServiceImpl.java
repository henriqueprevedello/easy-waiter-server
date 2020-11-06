package br.com.easywaiter.server.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easywaiter.server.repository.domain.Pedido;
import br.com.easywaiter.server.repository.jpa.PedidoRepository;
import br.com.easywaiter.server.service.ComandaService;
import br.com.easywaiter.server.service.PedidoService;
import br.com.easywaiter.server.util.dto.PedidoDTO;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ComandaService comandaService;

	@Override
	public void adicionar(PedidoDTO pedidoDTO) {

		Pedido pedido = new Pedido();

		pedido = modelMapper.map(pedidoDTO, Pedido.class);

		pedido.setCodigoComanda(comandaService
				.adquirirOuAbrir(pedidoDTO.getCodigoCliente(), pedidoDTO.getCodigoEstabelecimento()).getId());

		pedidoRepository.save(pedido);
	}

}
