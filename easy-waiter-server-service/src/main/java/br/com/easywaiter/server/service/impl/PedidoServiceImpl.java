package br.com.easywaiter.server.service.impl;

import static br.com.easywaiter.server.util.enumerator.StatusPedidoEnum.REALIZADO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

import br.com.easywaiter.server.repository.domain.Pedido;
import br.com.easywaiter.server.repository.domain.PedidoItem;
import br.com.easywaiter.server.repository.jpa.PedidoRepository;
import br.com.easywaiter.server.service.ComandaService;
import br.com.easywaiter.server.service.PedidoService;
import br.com.easywaiter.server.util.dto.ListagemPedidoDTO;
import br.com.easywaiter.server.util.dto.PedidoDTO;
import br.com.easywaiter.server.util.enumerator.StatusPedidoEnum;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Lazy
	@Autowired
	private ModelMapper modelMapper;

	@Lazy
	@Autowired
	private PedidoRepository pedidoRepository;

	@Lazy
	@Autowired
	private ComandaService comandaService;

	@Lazy
	@Autowired
	private PedidoItemServiceImpl pedidoItemService;

	@Override
	public Long adicionar(PedidoDTO pedidoDTO) throws Exception {

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
	public List<PedidoDTO> adquirirNaoFinalizados(Long codigoEstabelecimento) {

		List<Pedido> listaPedidos = pedidoRepository
				.adquirirNaoFinalizadosPorCodigoEstabelecimento(codigoEstabelecimento);

		return modelMapper.map(listaPedidos, TypeToken.getParameterized(List.class, PedidoDTO.class).getType());
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

	@Override
	public List<ListagemPedidoDTO> adquirirTodos(Long codigoCliente) {

		List<Pedido> listaPedidos = pedidoRepository.adquirirTodosPorCodigoClienteEmComandaAberta(codigoCliente);

		List<ListagemPedidoDTO> listaPedidosListagem = new ArrayList<ListagemPedidoDTO>();

		listaPedidos.forEach(pedido -> {

			ListagemPedidoDTO listagemPedidoDTO = new ListagemPedidoDTO();
			listagemPedidoDTO.setId(pedido.getId());
			listagemPedidoDTO.setValorTotal(this.calcularValorTotalPedidoItens(pedido.getPedidoItens()));
			listagemPedidoDTO.setQuantidadeProdutos(this.calcularQuantidadeTotalPedidoItens(pedido.getPedidoItens()));
			listagemPedidoDTO.setCodigoStatus(pedido.getCodigoStatus());

			listaPedidosListagem.add(listagemPedidoDTO);

		});

		return listaPedidosListagem;

	}

	private BigDecimal calcularValorTotalPedidoItens(List<PedidoItem> pedidoItens) {
		return pedidoItens.stream()
				.map(pitens -> BigDecimal.valueOf(pitens.getQuantidade()).multiply(pitens.getProduto().getValor()))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

	private Long calcularQuantidadeTotalPedidoItens(List<PedidoItem> pedidoItens) {
		return pedidoItens.stream().map(PedidoItem::getQuantidade).collect(Collectors.summingLong(Long::longValue));

	}

}
