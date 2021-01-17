package br.com.easywaiter.server.service.impl;

import static br.com.easywaiter.server.util.enumerator.StatusPedidoEnum.INICIADO;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

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

	@Autowired
	private PedidoItemServiceImpl pedidoItemService;

	@Override
	public Long adicionar(PedidoDTO pedidoDTO) {

		Pedido pedido = new Pedido();

		pedido = modelMapper.map(pedidoDTO, Pedido.class);

		pedido.setCodigoComanda(comandaService.adquirirOuAbrir(pedidoDTO.getCodigoCliente(),
				pedidoDTO.getCodigoEstabelecimento(), pedidoDTO.getCodigoMesa()).getId());

		pedido.setCodigoStatus(INICIADO.getCodigo());

		Long codigoPedido = pedidoRepository.save(pedido).getId();

		pedidoItemService.salvar(pedidoDTO.getPedidoItens(), codigoPedido);

		return codigoPedido;
	}

	@Override
	public PedidoDTO adquirir(Long codigoPedido) {
		Optional<Pedido> optionalPedido = pedidoRepository.findById(codigoPedido);

		if (optionalPedido.isPresent()) {

			return modelMapper.map(optionalPedido.get(), PedidoDTO.class);
		}

		return null;
	}

	@Override
	public List<PedidoDTO> adquirirNaoFinalizados(Long codigoEstabelecimento) {

		List<Pedido> listaPedidos = pedidoRepository
				.adquirirNaoFinalizadosPorCodigoEstabelecimento(codigoEstabelecimento);

		return modelMapper.map(listaPedidos, TypeToken.getParameterized(List.class, PedidoDTO.class).getType());
	}

}
