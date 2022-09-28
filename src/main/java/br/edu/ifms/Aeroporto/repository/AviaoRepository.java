package br.edu.ifms.Aeroporto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.Aeroporto.model.Aviao;

public interface AviaoRepository extends JpaRepository<Aviao, Integer> {

}
