package br.edu.ifms.Aeroporto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.Aeroporto.model.Passageiro;

public interface PassageiroRepository extends JpaRepository<Passageiro, Integer> {
	
}
