package br.com.lucas.model;

import java.io.Serializable;

/*
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
*/

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Medico extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int crm;

	@ManyToOne
	@JoinColumn(name = "consultorio_id")
	private Consultorio consultorio;

	@ManyToOne
	private Especialidade especialidade;

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
