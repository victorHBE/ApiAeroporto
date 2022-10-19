package br.edu.ifms.Aeroporto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.Aeroporto.dto.AviaoDto;
import br.edu.ifms.Aeroporto.exception.DataIntegrityException;
import br.edu.ifms.Aeroporto.exception.ObjectNotFoundException;
import br.edu.ifms.Aeroporto.model.Aviao;
import br.edu.ifms.Aeroporto.repository.AviaoRepository;

@Service
public class AviaoService {
	@Autowired
	private AviaoRepository repo;
	
	public Aviao buscarPorId(Integer id) {
		Optional<Aviao> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Aviao.class.getName()));		
	}
	
	public Aviao insert (Aviao obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Aviao update(Aviao obj) {
		Aviao newObj = buscarPorId(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		buscarPorId(id);
		try {
			repo.deleteById(id);	
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover. Verifique a integridade referencial.");
		}
	}

	public List<Aviao> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	public Aviao fromDto(AviaoDto objDto) {
		return new Aviao(objDto.getId(), objDto.getNumeroAviao(), objDto.getNomeFabricante(), objDto.getCapacidade(), objDto.getTipo(), null);
	}
	
	
	private void updateData(Aviao newObj, Aviao obj) {
		newObj.setNumeroAviao(obj.getNumeroAviao());
		newObj.setNomeFabricante(obj.getNomeFabricante());
		newObj.setTipo(obj.getTipo());
		newObj.setCapacidade(obj.getCapacidade());
	}

}
