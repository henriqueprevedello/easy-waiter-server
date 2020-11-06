package br.com.easywaiter.server.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easywaiter.server.repository.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
