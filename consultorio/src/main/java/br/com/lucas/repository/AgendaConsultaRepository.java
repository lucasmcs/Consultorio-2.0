package br.com.lucas.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.lucas.model.AgendaConsulta;

public interface AgendaConsultaRepository extends CrudRepository<AgendaConsulta, Long> {

//	List<AgendaConsulta> findByDataConsulta(Date dataInicio, Date dataFim);
}
