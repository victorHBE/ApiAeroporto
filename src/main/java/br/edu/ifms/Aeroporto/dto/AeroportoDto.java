package br.edu.ifms.Aeroporto.dto;

import java.io.Serializable;

import br.edu.ifms.Aeroporto.model.Aeroporto;

public class AeroportoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String codigo;
	
	private String nome;
	
	private String localizacao;

	public AeroportoDto() {
		
	}

	public AeroportoDto(Aeroporto obj) {
		super();
		this.id = obj.getId();
		this.codigo = obj.getCodigo();
		this.nome = obj.getNome();
		this.localizacao = obj.getLocalizacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
}
