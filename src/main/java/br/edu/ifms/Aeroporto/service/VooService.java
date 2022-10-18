package br.edu.ifms.Aeroporto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.Aeroporto.exception.DataIntegrityException;
import br.edu.ifms.Aeroporto.exception.ObjectNotFoundException;
import br.edu.ifms.Aeroporto.model.Voo;
import br.edu.ifms.Aeroporto.repository.VooRepository;

@Service
public class VooService {
	
	@Autowired
	private VooRepository repo;
	
	public Voo buscarPorId(Integer id) {
		Optional<Voo> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Voo.class.getName()));		
	}
	
	public Voo insert (Voo obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Voo update(Voo obj) {
		Voo newObj = buscarPorId(obj.getId());
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

	public List<Voo> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	private void updateData(Voo newObj, Voo obj) {
		newObj.setCompanhia(obj.getCompanhia());
		newObj.setHorario(obj.getHorario());
	}
}
