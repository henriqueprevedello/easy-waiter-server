package br.com.easywaiter.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.easywaiter.server.repository.domain.Cliente;
import br.com.easywaiter.server.repository.domain.Usuario;
import br.com.easywaiter.server.repository.jpa.ClienteRepository;
import br.com.easywaiter.server.repository.jpa.UsuarioRepository;
import br.com.easywaiter.server.service.UsuarioService;
import br.com.easywaiter.server.util.dto.UsuarioDTO;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void registrarCliente(UsuarioDTO usuarioDTO) {

		Usuario usuario = new Usuario();
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuarioDTO.getSenha()));
		usuario.setNome(usuarioDTO.getNome());

		usuario = usuarioRepository.save(usuario);

		Cliente cliente = new Cliente();
		cliente.setCodigoCliente(usuario.getId());

		clienteRepository.save(cliente);

	}

}
