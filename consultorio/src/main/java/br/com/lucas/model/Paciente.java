package br.com.lucas.model;

import javax.persistence.Entity;

@Entity
public class Paciente extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
//	private List<Consulta> consulta;

//	@OneToOne
//	private Prontuario prontuario;

//	public List<Consulta> getConsulta() {
//		return consulta;
//	}
//
//	public void setConsulta(List<Consulta> consulta) {
//		this.consulta = consulta;
//	}

//	public Prontuario getProntuario() {
//		return prontuario;
//	}
//
//	public void setProntuario(Prontuario prontuario) {
//		this.prontuario = prontuario;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
