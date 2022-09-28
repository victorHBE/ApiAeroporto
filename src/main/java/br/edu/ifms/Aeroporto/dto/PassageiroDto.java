package br.edu.ifms.Aeroporto.dto;

import java.io.Serializable;

import br.edu.ifms.Aeroporto.model.Passageiro;

public class PassageiroDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nome;
	
	private String cpf;

	public PassageiroDto() {
		
	}

	public PassageiroDto(Passageiro obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
