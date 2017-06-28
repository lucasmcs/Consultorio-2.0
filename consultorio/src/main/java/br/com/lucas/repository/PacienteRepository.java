package br.com.lucas.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.lucas.model.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {

}
