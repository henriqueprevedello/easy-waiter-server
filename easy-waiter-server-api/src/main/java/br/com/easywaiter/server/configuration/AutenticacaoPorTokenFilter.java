package br.com.easywaiter.server.configuration;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.easywaiter.server.repository.domain.Usuario;
import br.com.easywaiter.server.repository.jpa.UsuarioRepository;

public class AutenticacaoPorTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private UsuarioRepository usuarioRepository;

	public AutenticacaoPorTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = this.adquirirToken(request);

		boolean valido = tokenService.valido(token);

		if (valido) {

			this.autorizarCliente(token);
		}

		filterChain.doFilter(request, response);
	}

	private void autorizarCliente(String token) {
		Long idUsuario = tokenService.getIdUsuario(token);

		Usuario usuario = usuarioRepository.findById(idUsuario).get();

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null,
				usuario.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String adquirirToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");

		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}

		return token.substring(7, token.length());
	}

}
