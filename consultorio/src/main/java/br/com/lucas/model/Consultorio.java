package br.com.lucas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Consultorio extends Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String CNPJ;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "consultorio")
//	private List<Medico> medicos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

//	public List<Medico> getMedicos() {
//		return medicos;
//	}
//
//	public void setMedicos(List<Medico> medicos) {
//		this.medicos = medicos;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
