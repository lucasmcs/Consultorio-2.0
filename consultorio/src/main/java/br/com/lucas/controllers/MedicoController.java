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

import br.com.lucas.model.Consultorio;
import br.com.lucas.model.Especialidade;
import br.com.lucas.model.Medico;
import br.com.lucas.repository.ConsultorioRepository;
import br.com.lucas.repository.EspecialidadeRepository;
import br.com.lucas.repository.MedicoRepository;

@RestController
public class MedicoController {
	
	@Autowired MedicoRepository medicoRepository;
	@Autowired ConsultorioRepository consultorioRepository;
	@Autowired EspecialidadeRepository especialidadeRepository;
	
	// LISTAR MEDICO
	@GetMapping(path = "/listarMedico/{idMedico}")
	public Medico buscar(@PathVariable Long idMedico) {		
		return medicoRepository.findOne(idMedico);
	}
	
	// LISTAR TODAS AS MEDICOS
	@GetMapping(path = "/listarMedicos")
	public List<Medico> listarMedicos() {
		return (List<Medico>) medicoRepository.findAll();
	}

	// CADASTRO MEDICO
	@PostMapping(path = "/inserirMedico/{idConsultorio}/{idEspecialidade}")
	public @ResponseBody String cadastrarMedico(
			@PathVariable Long idConsultorio,
			@PathVariable Long idEspecialidade,
			@RequestBody Medico medico) {

		Consultorio consultorio = consultorioRepository.findOne(idConsultorio);
		if (consultorio == null) {
			return "Consultorio não encontrado";
		}
		Especialidade especialidade = especialidadeRepository.findOne(idEspecialidade);
		if (especialidade == null) {
			return "Especialidade não encontrada";
		}
		
		medico.setConsultorio(consultorio);
		medico.setEspecialidade(especialidade);
		
		medicoRepository.save(medico);

		return "Medico(a) inserido(a)";
	}
	
	// DELETAR
	@DeleteMapping(path = "/deleteMedico/{idMedico}")
	public String deletar(
			@PathVariable Long idMedico) {
		
		Medico medico = medicoRepository.findOne(idMedico);
		if (medico == null) {
			return "Medico não encontrada";
		}
		
		medicoRepository.delete(idMedico);
		
		return "Medico deletada com sucesso";
	}
	
	// EDITAR
	@PutMapping(path = "/editarMedico/{idMedico}/{idConsultorio}/{idEspecialidade}")
	public String atualizar(
			@PathVariable Long idMedico,
			@PathVariable Long idConsultorio,
			@PathVariable Long idEspecialidade,
			@RequestBody Medico medico) {
		
		Medico selecionado = medicoRepository.findOne(idMedico);
		if (selecionado == null) {
			return "Medico não encontrada";
		}
		Consultorio consultorio = consultorioRepository.findOne(idConsultorio);
		if (consultorio == null) {
			return "Consultorio não encontrado";
		}
		Especialidade especialidade = especialidadeRepository.findOne(idEspecialidade);
		if (especialidade == null) {
			return "Especialidade não encontrada";
		}
		
		selecionado.setConsultorio(consultorio);
		selecionado.setCrm(medico.getCrm());
		selecionado.setEspecialidade(medico.getEspecialidade());
		
		selecionado.setBairro(medico.getBairro());
		selecionado.setCidade(medico.getCidade());
		selecionado.setLogradouro(medico.getLogradouro());
		selecionado.setNome(medico.getNome());
		selecionado.setNumero(medico.getNumero());
		selecionado.setUf(medico.getUf());
		
		medicoRepository.save(selecionado);
		
		return "Medico editada com sucesso";
	}
}
