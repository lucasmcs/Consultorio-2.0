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

import br.com.lucas.model.Pessoa;
import br.com.lucas.repository.PessoaRepository;

@RestController
public class PessoaController {
	
	@Autowired PessoaRepository pessoaRepository;
	
	// LISTAR PESSOA
	@GetMapping(path = "/listarPessoa/{idPessoa}")
	public Pessoa buscar(@PathVariable Long idPessoa) {		
		return pessoaRepository.findOne(idPessoa);
	}
	
	// LISTAR TODAS AS PESSOAS
	@GetMapping(path = "/listarPessoas")
	public List<Pessoa> listarPessoas() {
		return (List<Pessoa>) pessoaRepository.findAll();
	}

	// CADASTRO PESSOA
	@PostMapping(path = "/inserirPessoa")
	public @ResponseBody String cadastrarPessoa(
			@RequestBody Pessoa pessoa) {

		pessoaRepository.save(pessoa);

		return "Pessoa inserida";
	}
	
	// DELETAR
	@DeleteMapping(path = "/deletePessoa/{idPessoa}")
	public String deletar(
			@PathVariable Long idPessoa) {
		
		Pessoa pessoa = pessoaRepository.findOne(idPessoa);
		if (pessoa == null) {
			return "Pessoa não encontrada";
		}
		
		pessoaRepository.delete(idPessoa);
		
		return "Pessoa deletada com sucesso";
	}
	
	// EDITAR
	@PutMapping(path = "/editarPessoa/{idPessoa}")
	public String atualizar(
			@PathVariable Long idPessoa,
			@RequestBody Pessoa pessoa) {
		
		Pessoa p = pessoaRepository.findOne(idPessoa);
		if (p == null) {
			return "Pessoa não encontrada";
		}
		
		p.setBairro(pessoa.getBairro());
		p.setCidade(pessoa.getCidade());
		p.setLogradouro(pessoa.getLogradouro());
		p.setNome(pessoa.getNome());
		p.setNumero(pessoa.getNumero());
		p.setUf(pessoa.getUf());
		
		pessoaRepository.save(p);
		
		return "Pessoa editada com sucesso";
	}
}
