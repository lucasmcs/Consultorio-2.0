package br.com.lucas.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.lucas.model.Medico;

public interface MedicoRepository extends CrudRepository<Medico, Long> {

}
