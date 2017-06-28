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

import br.com.lucas.model.Paciente;
import br.com.lucas.repository.PacienteRepository;

@RestController
public class PacienteController {
	
	@Autowired PacienteRepository pacienteRepository;
	
	// LISTAR PACIENTE
	@GetMapping(path = "/listarPaciente/{idPaciente}")
	public Paciente buscar(@PathVariable Long idPaciente) {		
		return pacienteRepository.findOne(idPaciente);
	}
	
	// LISTAR TODAS OS PACIENTES
	@GetMapping(path = "/listarPacientes")
	public List<Paciente> listarPacientes() {
		return (List<Paciente>) pacienteRepository.findAll();
	}

	// CADASTRO PACIENTE
	@PostMapping(path = "/inserirPaciente")
	public @ResponseBody String cadastrarPaciente(
			@RequestBody Paciente paciente) {

		pacienteRepository.save(paciente);

		return "Paciente inserido(a)";
	}
	
	// DELETAR
	@DeleteMapping(path = "/deletePaciente/{idPaciente}")
	public String deletar(
			@PathVariable Long idPaciente) {
		
		Paciente paciente = pacienteRepository.findOne(idPaciente);
		if (paciente == null) {
			return "Paciente não encontrada";
		}
		
		pacienteRepository.delete(idPaciente);
		
		return "Paciente deletado(a) com sucesso";
	}
	
	// EDITAR
	@PutMapping(path = "/editarPaciente/{idPaciente}")
	public String atualizar(
			@PathVariable Long idPaciente,
			@RequestBody Paciente paciente) {
		
		Paciente p = pacienteRepository.findOne(idPaciente);
		if (p == null) {
			return "Paciente não encontrada";
		}
		
		p.setBairro(paciente.getBairro());
		p.setCidade(paciente.getCidade());
		p.setLogradouro(paciente.getLogradouro());
		p.setNome(paciente.getNome());
		p.setNumero(paciente.getNumero());
		p.setUf(paciente.getUf());
		
		pacienteRepository.save(p);
		
		return "Paciente editado(a) com sucesso";
	}
}
