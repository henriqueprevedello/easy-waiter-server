package br.com.easywaiter.server.service.impl;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

import br.com.easywaiter.server.repository.domain.Comanda;
import br.com.easywaiter.server.repository.domain.Pedido;
import br.com.easywaiter.server.repository.domain.PedidoItem;
import br.com.easywaiter.server.repository.jpa.ComandaRepository;
import br.com.easywaiter.server.service.ComandaService;
import br.com.easywaiter.server.util.dto.ComandaDTO;
import br.com.easywaiter.server.util.enumerator.StatusPedidoEnum;

@Service
public class ComandaServiceImpl implements ComandaService {

	@Autowired
	private ComandaRepository comandaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Comanda adquirirOuAbrir(Long codigoCliente, Long codigoEstabelecimento, Long codigoMesa) {

		Optional<Comanda> optionalComanda = comandaRepository
				.findByCodigoEstabelecimentoAndCodigoClienteAndDataFechamentoIsNull(codigoEstabelecimento,
						codigoCliente);

		if (optionalComanda.isPresent()) {

			return optionalComanda.get();
		}

		Comanda comanda = new Comanda();
		comanda.setCodigoCliente(codigoCliente);
		comanda.setCodigoEstabelecimento(codigoEstabelecimento);
		comanda.setCodigoMesa(codigoMesa);

		return comandaRepository.save(comanda);
	}

	@Override
	public List<ComandaDTO> adquirirTodas(Long codigoEstabelecimento) {

		return modelMapper.map(
				comandaRepository.findByCodigoEstabelecimentoAndDataFechamentoIsNull(codigoEstabelecimento),
				TypeToken.getParameterized(List.class, ComandaDTO.class).getType());
	}

	@Override
	public ComandaDTO adquirir(Long codigoComanda) throws Exception {

		Optional<Comanda> optionalComanda = comandaRepository.findById(codigoComanda);

		if (optionalComanda.isPresent()) {

			ComandaDTO comandaDTO = modelMapper.map(optionalComanda.get(), ComandaDTO.class);

			comandaDTO.setValorTotal(this.calcularValorTotal(optionalComanda.get().getPedidos()));

			return comandaDTO;
		}

		throw new Exception("Comanda não encontrada");
	}

	private BigDecimal calcularValorTotal(List<Pedido> pedidos) {
		return pedidos.stream().map(pedido -> this.calcularValorTotalPedidoItens(pedido.getPedidoItens()))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

	private BigDecimal calcularValorTotalPedidoItens(List<PedidoItem> pedidoItens) {
		return pedidoItens.stream()
				.map(pitens -> BigDecimal.valueOf(pitens.getQuantidade()).multiply(pitens.getProduto().getValor()))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

	@Override
	public void pagar(Long codigoComanda) throws Exception {

		Optional<Comanda> optionalComanda = comandaRepository.findById(codigoComanda);

		if (optionalComanda.isPresent()) {

			Comanda comanda = optionalComanda.get();

			if (this.contemPedidoPendente(comanda)) {

				throw new Exception("Não é possível fechar a comanda pois possui pedidos não finalizados.");
			}

			comanda.setDataFechamento(Date.from(Instant.now()));

			comandaRepository.save(comanda);

		}

		throw new Exception("Comanda não encontrada");
	}

	private boolean contemPedidoPendente(Comanda comanda) {
		return comanda.getPedidos().stream().anyMatch(pedido -> !StatusPedidoEnum.getFinalizados()
				.contains(StatusPedidoEnum.getEnum(pedido.getCodigoStatus())));
	}

}
