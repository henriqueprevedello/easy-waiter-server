package br.com.easywaiter.server.service.impl;

import static br.com.easywaiter.server.util.enumerator.StatusPedidoEnum.REALIZADO;

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
import br.com.easywaiter.server.util.dto.PedidoExporDTO;
import br.com.easywaiter.server.util.enumerator.StatusPedidoEnum;

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

		pedido.setCodigoStatus(REALIZADO.getCodigo());

		Long codigoPedido = pedidoRepository.save(pedido).getId();

		pedidoItemService.salvar(pedidoDTO.getPedidoItens(), codigoPedido);

		return codigoPedido;
	}

	@Override
	public PedidoDTO adquirirDTO(Long codigoPedido) {
		Optional<Pedido> optionalPedido = pedidoRepository.findById(codigoPedido);

		if (optionalPedido.isPresent()) {

			return modelMapper.map(optionalPedido.get(), PedidoDTO.class);
		}

		return null;
	}

	@Override
	public List<PedidoExporDTO> adquirirNaoFinalizados(Long codigoEstabelecimento) {

		List<Pedido> listaPedidos = pedidoRepository
				.adquirirNaoFinalizadosPorCodigoEstabelecimento(codigoEstabelecimento);

		return modelMapper.map(listaPedidos, TypeToken.getParameterized(List.class, PedidoExporDTO.class).getType());
	}

	@Override
	public void prosseguir(Long codigoPedido) throws Exception {
		Pedido pedido = pedidoRepository.findById(codigoPedido)
				.orElseThrow(() -> new Exception("Pedido não encontrado"));

		switch (StatusPedidoEnum.getEnum(pedido.getCodigoStatus())) {

		case REALIZADO:
			pedido.setCodigoStatus(StatusPedidoEnum.CONFIRMADO.getCodigo());
			break;

		case CONFIRMADO:
			pedido.setCodigoStatus(StatusPedidoEnum.EM_PREPARO.getCodigo());
			break;

		case EM_PREPARO:
			pedido.setCodigoStatus(StatusPedidoEnum.EM_ENTREGA.getCodigo());
			break;

		case EM_ENTREGA:
			pedido.setCodigoStatus(StatusPedidoEnum.ENTREGUE.getCodigo());
			break;

		default:
			break;
		}

		pedidoRepository.save(pedido);

	}

	@Override
	public void recusar(Long codigoPedido) throws Exception {

		Pedido pedido = pedidoRepository.findById(codigoPedido)
				.orElseThrow(() -> new Exception("Pedido não encontrado"));

		pedido.setCodigoStatus(StatusPedidoEnum.RECUSADO.getCodigo());

		pedidoRepository.save(pedido);

	}

}
