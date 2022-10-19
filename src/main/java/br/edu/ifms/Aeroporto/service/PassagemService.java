package br.edu.ifms.Aeroporto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.Aeroporto.dto.PassagemDto;
import br.edu.ifms.Aeroporto.exception.DataIntegrityException;
import br.edu.ifms.Aeroporto.exception.ObjectNotFoundException;
import br.edu.ifms.Aeroporto.model.Passagem;
import br.edu.ifms.Aeroporto.repository.PassagemRepository;

@Service
public class PassagemService {
	@Autowired
	private PassagemRepository repo;
	
	public Passagem buscarPorId(Integer id) {
		Optional<Passagem> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Passagem.class.getName()));		
	}
	
	public Passagem insert (Passagem obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Passagem update(Passagem obj) {
		Passagem newObj = buscarPorId(obj.getId());
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

	public List<Passagem> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	public Passagem fromDto(PassagemDto objDto) {
		return new Passagem(objDto.getId(), objDto.getValor(), objDto.getHorario(), objDto.getData(), null, null);
	}
	
	private void updateData(Passagem newObj, Passagem obj) {
		newObj.setValor(obj.getValor());
		newObj.setData(obj.getData());
		newObj.setHorario(obj.getHorario());
	}
}
