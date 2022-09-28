package br.edu.ifms.Aeroporto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.Aeroporto.model.Passagem;

public interface PassagemRepository extends JpaRepository<Passagem, Integer> {
	
}
