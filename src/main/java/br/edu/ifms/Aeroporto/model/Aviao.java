package br.edu.ifms.Aeroporto.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Aviao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int numeroAviao;
	
	private String nomeFabricante;
	
	private int capacidade;
	
	private String tipo;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy = "aviao")
	private Voo voo;
	

	public Aviao() {
		
	}


	public Aviao(Integer id, int numeroAviao, String nomeFabricante, int capacidade, String tipo, Voo voo) {
		super();
		this.id = id;
		this.numeroAviao = numeroAviao;
		this.nomeFabricante = nomeFabricante;
		this.capacidade = capacidade;
		this.tipo = tipo;
		this.voo = voo;
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

	public Voo getVoo() {
		return voo;
	}


	public void setVoo(Voo voo) {
		this.voo = voo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aviao other = (Aviao) obj;
		return Objects.equals(id, other.id);
	}

}
