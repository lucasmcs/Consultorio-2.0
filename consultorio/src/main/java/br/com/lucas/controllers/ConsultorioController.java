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
import br.com.lucas.repository.ConsultorioRepository;

@RestController
public class ConsultorioController {
	
	@Autowired ConsultorioRepository consultorioRepository;
	
	// LISTAR CONSULTORIO
	@GetMapping(path = "/listarConsultorio/{idConsultorio}")
	public Consultorio buscar(@PathVariable Long idConsultorio) {		
		return consultorioRepository.findOne(idConsultorio);
	}
	
	// LISTAR TODOS OS CONSULTORIOS
	@GetMapping(path = "/listarConsultorios")
	public List<Consultorio> listarConsultorios() {
		return (List<Consultorio>) consultorioRepository.findAll();
	}

	// CADASTRO CONSULTORIO
	@PostMapping(path = "/inserirConsultorio")
	public @ResponseBody String cadastrarConsultorio(
			@RequestBody Consultorio consultorio) {

		consultorioRepository.save(consultorio);

		return "Consultorio inserido";
	}
	
	// DELETAR
	@DeleteMapping(path = "/deleteConsultorio/{idConsultorio}")
	public String deletar(
			@PathVariable Long idConsultorio) {
		
		Consultorio consultorio = consultorioRepository.findOne(idConsultorio);
		if (consultorio == null) {
			return "Consultorio não encontrada";
		}
		
		consultorioRepository.delete(idConsultorio);
		
		return "Consultorio deletada com sucesso";
	}
	
	// EDITAR
	@PutMapping(path = "/editarConsultorio/{idConsultorio}")
	public String atualizar(
			@PathVariable Long idConsultorio,
			@RequestBody Consultorio consultorio) {
		
		Consultorio selecionado = consultorioRepository.findOne(idConsultorio);
		if (selecionado == null) {
			return "Consultorio não encontrada";
		}
		
		selecionado.setCNPJ(consultorio.getCNPJ());

		selecionado.setBairro(consultorio.getBairro());
		selecionado.setCidade(consultorio.getCidade());
		selecionado.setLogradouro(consultorio.getLogradouro());
		selecionado.setNome(consultorio.getNome());
		selecionado.setNumero(consultorio.getNumero());
		selecionado.setUf(consultorio.getUf());
		
		consultorioRepository.save(selecionado);
		
		return "Consultorio editada com sucesso";
	}
}
