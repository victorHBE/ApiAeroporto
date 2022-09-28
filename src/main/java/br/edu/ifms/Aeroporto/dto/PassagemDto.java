package br.edu.ifms.Aeroporto.dto;

import java.io.Serializable;

import br.edu.ifms.Aeroporto.model.Passagem;

public class PassagemDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private float valor;
	
	private String data;
	
	private String horario;

	public PassagemDto() {
		
	}

	public PassagemDto(Passagem obj) {
		super();
		this.id = obj.getId();
		this.valor = obj.getValor();
		this.data = obj.getData();
		this.horario = obj.getHorario();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
}
