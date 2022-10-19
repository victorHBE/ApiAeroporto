package br.edu.ifms.Aeroporto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.Aeroporto.dto.PassageiroDto;
import br.edu.ifms.Aeroporto.exception.DataIntegrityException;
import br.edu.ifms.Aeroporto.exception.ObjectNotFoundException;
import br.edu.ifms.Aeroporto.model.Passageiro;
import br.edu.ifms.Aeroporto.repository.PassageiroRepository;

@Service
public class PassageiroService {

	@Autowired
	private PassageiroRepository repo;
	
	public Passageiro buscarPorId(Integer id) {
		Optional<Passageiro> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Passageiro.class.getName()));		
	}
	
	public Passageiro insert (Passageiro obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Passageiro update(Passageiro obj) {
		Passageiro newObj = buscarPorId(obj.getId());
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

	public List<Passageiro> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	public Passageiro fromDto(PassageiroDto objDto) {
		return new Passageiro(objDto.getId(), objDto.getCpf(), objDto.getNome());
	}
	
	private void updateData(Passageiro newObj, Passageiro obj) {
		newObj.setNome(obj.getNome());
		newObj.setCpf(obj.getCpf());
	}
}
