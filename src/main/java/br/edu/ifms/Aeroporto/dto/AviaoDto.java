package br.edu.ifms.Aeroporto.dto;

import java.io.Serializable;

import br.edu.ifms.Aeroporto.model.Aviao;

public class AviaoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private int numeroAviao;
	
	private String nomeFabricante;
	
	private int capacidade;
	
	private String tipo;

	public AviaoDto() {
		
	}

	public AviaoDto(Aviao obj) {
		super();
		this.id = obj.getId();
		this.numeroAviao = obj.getNumeroAviao();
		this.nomeFabricante = obj.getNomeFabricante();
		this.capacidade = obj.getCapacidade();
		this.tipo = obj.getTipo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumeroAviao() {
		return numeroAviao;
	}

	public void setNumeroAviao(int numeroAviao) {
		this.numeroAviao = numeroAviao;
	}

	public String getNomeFabricante() {
		return nomeFabricante;
	}

	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
