package br.com.exemploapi.personapi.repository;

import br.com.exemploapi.personapi.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
}
