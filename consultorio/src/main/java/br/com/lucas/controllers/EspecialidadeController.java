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

import br.com.lucas.model.Especialidade;
import br.com.lucas.repository.EspecialidadeRepository;

@RestController
public class EspecialidadeController {
	
	@Autowired EspecialidadeRepository especialidadeRepository;
	
	// LISTAR ESPECIALIDADE
	@GetMapping(path = "/listarEspecialidade/{idEspecialidade}")
	public Especialidade buscar(@PathVariable Long idEspecialidade) {		
		return especialidadeRepository.findOne(idEspecialidade);
	}
	
	// LISTAR TODAS AS ESPECIALIDADES
	@GetMapping(path = "/listarEspecialidades")
	public List<Especialidade> listarEspecialidades() {
		return (List<Especialidade>) especialidadeRepository.findAll();
	}

	// CADASTRO ESPECIALIDADE
	@PostMapping(path = "/inserirEspecialidade")
	public @ResponseBody String cadastrarEspecialidade(
			@RequestBody Especialidade especialidade) {

		especialidadeRepository.save(especialidade);

		return "Especialidade inserida";
	}
	
	// DELETAR
	@DeleteMapping(path = "/deleteEspecialidade/{idEspecialidade}")
	public String deletar(
			@PathVariable Long idEspecialidade) {
		
		Especialidade especialidade = especialidadeRepository.findOne(idEspecialidade);
		if (especialidade == null) {
			return "Especialidade não encontrada";
		}
		
		especialidadeRepository.delete(idEspecialidade);
		
		return "Especialidade deletada com sucesso";
	}
	
	// EDITAR
	@PutMapping(path = "/editarEspecialidade/{idEspecialidade}")
	public String atualizar(
			@PathVariable Long idEspecialidade,
			@RequestBody Especialidade especialidade) {
		
		Especialidade selecionado = especialidadeRepository.findOne(idEspecialidade);
		if (selecionado == null) {
			return "Especialidade não encontrada";
		}
		
		selecionado.setDescricao(especialidade.getDescricao());
		
		especialidadeRepository.save(selecionado);
		
		return "Especialidade editada com sucesso";
	}
}
