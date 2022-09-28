package br.edu.ifms.Aeroporto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.Aeroporto.model.Voo;

public interface VooRepository extends JpaRepository<Voo, Integer> {

}
