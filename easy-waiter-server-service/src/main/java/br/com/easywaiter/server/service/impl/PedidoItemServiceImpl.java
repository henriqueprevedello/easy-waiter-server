package br.com.easywaiter.server.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;

import br.com.easywaiter.server.repository.domain.PedidoItem;
import br.com.easywaiter.server.repository.jpa.PedidoItemRepository;
import br.com.easywaiter.server.service.PedidoItemService;
import br.com.easywaiter.server.util.dto.PedidoItemDTO;

@Service
public class PedidoItemServiceImpl implements PedidoItemService {

	@Autowired
	private PedidoItemRepository pedidoItemRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void salvar(List<PedidoItemDTO> pedidoItens, Long codigoPedido) {

		List<PedidoItem> listaPersistir = modelMapper.map(pedidoItens,
				TypeToken.getParameterized(List.class, PedidoItem.class).getType());

		listaPersistir.forEach(pedidoItem -> pedidoItem.setCodigoPedido(codigoPedido));

		pedidoItemRepository.saveAll(listaPersistir);

	}

}
