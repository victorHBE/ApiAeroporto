package br.edu.ifms.Aeroporto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.Aeroporto.model.Aeroporto;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Integer> {
	
}
