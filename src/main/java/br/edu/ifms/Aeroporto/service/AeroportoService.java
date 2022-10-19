package br.edu.ifms.Aeroporto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.Aeroporto.dto.AeroportoDto;
import br.edu.ifms.Aeroporto.exception.DataIntegrityException;
import br.edu.ifms.Aeroporto.exception.ObjectNotFoundException;
import br.edu.ifms.Aeroporto.model.Aeroporto;
import br.edu.ifms.Aeroporto.repository.AeroportoRepository;


@Service
public class AeroportoService {
	@Autowired
	private AeroportoRepository repo;
	
	public Aeroporto buscarPorId(Integer id) {
		Optional<Aeroporto> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Aeroporto.class.getName()));		
	}
	
	public Aeroporto insert (Aeroporto obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Aeroporto update(Aeroporto obj) {
		Aeroporto newObj = buscarPorId(obj.getId());
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

	public List<Aeroporto> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	public Aeroporto fromDto(AeroportoDto objDto) {
		return new Aeroporto(objDto.getId(), objDto.getCodigo(), objDto.getLocalizacao(), objDto.getNome());
	}
	

	
	private void updateData(Aeroporto newObj, Aeroporto obj) {
		newObj.setCodigo(obj.getCodigo());
		newObj.setNome(obj.getNome());
		newObj.setLocalizacao(obj.getLocalizacao());
	}

}
