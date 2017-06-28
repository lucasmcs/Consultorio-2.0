package br.com.lucas.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.lucas.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
