package br.edu.ifms.Aeroporto.dto;

import java.io.Serializable;

import br.edu.ifms.Aeroporto.model.Voo;

public class VooDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String companhia;
	
	private String horario;

	public VooDto() {
		
	}

	public VooDto(Voo obj) {
		super();
		this.id = obj.getId();
		this.companhia = obj.getCompanhia();
		this.horario = obj.getHorario();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanhia() {
		return companhia;
	}

	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
}
