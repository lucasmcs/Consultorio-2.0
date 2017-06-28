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

import br.com.lucas.model.Convenio;
import br.com.lucas.repository.ConvenioRepository;

@RestController
public class ConvenioController {
	
	@Autowired ConvenioRepository convenioRepository;
	
	// LISTAR CONVENIO
	@GetMapping(path = "/listarConvenio/{idConvenio}")
	public Convenio buscar(@PathVariable Long idConvenio) {		
		return convenioRepository.findOne(idConvenio);
	}
	
	// LISTAR TODAS AS CONVENIOS
	@GetMapping(path = "/listarConvenios")
	public List<Convenio> listarConvenios() {
		return (List<Convenio>) convenioRepository.findAll();
	}

	// CADASTRO CONVENIO
	@PostMapping(path = "/inserirConvenio")
	public @ResponseBody String cadastrarConvenio(
			@RequestBody Convenio convenio) {

		convenioRepository.save(convenio);

		return "Convenio inserida";
	}
	
	// DELETAR
	@DeleteMapping(path = "/deleteConvenio/{idConvenio}")
	public String deletar(
			@PathVariable Long idConvenio) {
		
		Convenio convenio = convenioRepository.findOne(idConvenio);
		if (convenio == null) {
			return "Convenio não encontrada";
		}
		
		convenioRepository.delete(idConvenio);
		
		return "Convenio deletada com sucesso";
	}
	
	// EDITAR
	@PutMapping(path = "/editarConvenio/{idConvenio}")
	public String atualizar(
			@PathVariable Long idConvenio,
			@RequestBody Convenio convenio) {
		
		Convenio selecionado = convenioRepository.findOne(idConvenio);
		if (selecionado == null) {
			return "Convenio não encontrada";
		}
		
		selecionado.setDescricao(convenio.getDescricao());
		
		convenioRepository.save(selecionado);
		
		return "Convenio editada com sucesso";
	}
}
