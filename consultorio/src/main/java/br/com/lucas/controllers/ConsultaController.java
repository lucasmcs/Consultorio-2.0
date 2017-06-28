/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.model.Consulta;
import br.com.lucas.model.Convenio;
import br.com.lucas.model.Medico;
import br.com.lucas.model.Paciente;
import br.com.lucas.repository.ConsultaRepository;
import br.com.lucas.repository.ConvenioRepository;
import br.com.lucas.repository.MedicoRepository;
import br.com.lucas.repository.PacienteRepository;

@RestController
public class ConsultaController {
	
	@Autowired ConsultaRepository consultaRepository;
	@Autowired ConvenioRepository convenioRepository;
	@Autowired MedicoRepository medicoRepository;
	@Autowired PacienteRepository pacienteRepository;
	
	// LISTAR CONSULTA
	@GetMapping(path = "/listarConsulta/{idConsulta}")
	public Consulta buscar(@PathVariable Long idConsulta) {		
		return consultaRepository.findOne(idConsulta);
	}
	
	// LISTAR TODAS AS CONSULTAS
	@GetMapping(path = "/listarConsultas")
	public List<Consulta> listarConsultas() {
		return (List<Consulta>) consultaRepository.findAll();
	}

	// CADASTRO CONSULTA
	@PostMapping(path = "/inserirConsulta/{idConvenio}/{idMedico}/{idPaciente}")
	public @ResponseBody String cadastrarConsulta(
			@PathVariable Long idConvenio,
			@PathVariable Long idMedico,
			@PathVariable Long idPaciente,
			@RequestBody Consulta consulta) {

		Convenio convenio = convenioRepository.findOne(idConvenio);
		if (convenio == null) {
			return "Convenio não encontrado";
		}
		
		Medico medico = medicoRepository.findOne(idMedico);
		if (medico == null) {
			return "Medico(a) não encontrado(a)";
		}
		
		Paciente paciente = pacienteRepository.findOne(idPaciente);
		if (paciente == null) {
			return "Paciente não encontrado(a)";
		}
		
		consulta.setConvenio(convenio);
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);
		
//		if (consulta.getConvenio().getDescricao().equals("SUS")) {
//			consulta.setPreco(0);
//		}
		
		consultaRepository.save(consulta);

		return "Consulta efetuada com sucesso";
	}
	
	// DELETAR
	@DeleteMapping(path = "/deleteConsulta/{idConsulta}")
	public String deletar(
			@PathVariable Long idConsulta) {
		
		Consulta consulta = consultaRepository.findOne(idConsulta);
		if (consulta == null) {
			return "Consulta não encontrada";
		}
		
		consultaRepository.delete(idConsulta);
		
		return "Consulta deletada com sucesso";
	}
	
	// EDITAR
	@PutMapping(path = "/editarConsulta/{idConsulta}/{idConvenio}/{idMedico}/{idPaciente}")
	public String atualizar(
			@PathVariable Long idConsulta,
			@PathVariable Long idConvenio,
			@PathVariable Long idMedico,
			@PathVariable Long idPaciente,
			@RequestBody Consulta consulta) {
		
		Consulta selecionado = consultaRepository.findOne(idConsulta);
		if (selecionado == null) {
			return "Consulta não encontrada";
		}
		
		Convenio convenio = convenioRepository.findOne(idConvenio);
		if (convenio == null) {
			return "Convenio não encontrado";
		}
		
		Medico medico = medicoRepository.findOne(idMedico);
		if (medico == null) {
			return "Medico(a) não encontrado(a)";
		}
		
		Paciente paciente = pacienteRepository.findOne(idPaciente);
		if (paciente == null) {
			return "Paciente não encontrado(a)";
		}
		
		selecionado.setConvenio(convenio);
		selecionado.setMedico(medico);
		selecionado.setPaciente(paciente);
		
//		if (selecionado.getConvenio().getDescricao().equals("SUS")) {
//			selecionado.setPreco(0);
//		} else {
			selecionado.setPreco(consulta.getPreco());
//		}
		
		consultaRepository.save(selecionado);
		
		return "Consulta editada com sucesso";
	}
}
