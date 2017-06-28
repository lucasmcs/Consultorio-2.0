/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.model.AgendaConsulta;
import br.com.lucas.model.Consulta;
import br.com.lucas.repository.AgendaConsultaRepository;
import br.com.lucas.repository.ConsultaRepository;

@RestController
public class AgendaConsultaController {
	
	@Autowired AgendaConsultaRepository agendaConsultaRepository;
	@Autowired ConsultaRepository consultaRepository;
	private List<Consulta> consultas;
	
	// LISTAR PESSOA
//	@GetMapping(path = "/agenda/{dataInicio}/{dataFim}")
//	public List<AgendaConsulta> buscar(
//			@PathVariable Date dataInicio,
//			@PathVariable Date dataFim) {		
//		return agendaConsultaRepository.findByDataConsulta(dataInicio, dataFim);
//	}
	
	// LISTAR AGENDA
	@GetMapping(path = "/agenda")
	public Iterable<AgendaConsulta> listar() {
		return agendaConsultaRepository.findAll();
	}

	// CADASTRO PESSOA
	@PostMapping(path = "/agendar/{idConsulta}")
	public @ResponseBody String agendar(
			@RequestBody AgendaConsulta agendaConsulta,
			@PathVariable Long idConsulta) {

		Consulta consulta = consultaRepository.findOne(idConsulta);
		if (consulta == null) {
			return "Consulta não encontrada";
		}
				
		consultas.add(consulta);
		
		agendaConsulta.setConsultas(consultas);
		
		agendaConsultaRepository.save(agendaConsulta);

		return "Consulta agendada.";
	}
//	
//	// DELETAR
//	@DeleteMapping(path = "/deletePessoa/{idPessoa}")
//	public String deletar(
//			@PathVariable Long idPessoa) {
//		
//		Pessoa pessoa = pessoaRepository.findOne(idPessoa);
//		if (pessoa == null) {
//			return "Pessoa não encontrada";
//		}
//		
//		pessoaRepository.delete(idPessoa);
//		
//		return "Pessoa deletada com sucesso";
//	}
//	
//	// EDITAR
//	@PutMapping(path = "/editarPessoa/{idPessoa}")
//	public String atualizar(
//			@PathVariable Long idPessoa,
//			@RequestBody Pessoa pessoa) {
//		
//		Pessoa p = pessoaRepository.findOne(idPessoa);
//		if (p == null) {
//			return "Pessoa não encontrada";
//		}
//		
//		p.setBairro(pessoa.getBairro());
//		p.setCidade(pessoa.getCidade());
//		p.setLogradouro(pessoa.getLogradouro());
//		p.setNome(pessoa.getNome());
//		p.setNumero(pessoa.getNumero());
//		p.setUf(pessoa.getUf());
//		
//		pessoaRepository.save(p);
//		
//		return "Pessoa editada com sucesso";
//	}
}
