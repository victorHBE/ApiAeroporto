package br.edu.ifms.Aeroporto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Voo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String companhia;
	
	private String horario;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="aeroporto_id")
	private Aeroporto aeroporto;
	
	@OneToOne
	@JoinColumn(name="aviao_id")
	private Aviao aviao;
	
	@OneToMany(mappedBy = "voo")
	private List<Passagem> passagens = new ArrayList<Passagem>();

	public Voo() {
		
	}

	public Voo(Integer id, String companhia, String horario, Aeroporto aeroporto, Aviao aviao) {
		super();
		this.id = id;
		this.companhia = companhia;
		this.horario = horario;
		this.aeroporto = aeroporto;
		this.aviao = aviao;
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
	

	public Aeroporto getAeroporto() {
		return aeroporto;
	}


	public void setAeroporto(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	public List<Passagem> getPassagens() {
		return passagens;
	}

	public void setPassagens(List<Passagem> passagens) {
		this.passagens = passagens;
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
		Voo other = (Voo) obj;
		return Objects.equals(id, other.id);
	}
		
}
