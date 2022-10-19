package br.edu.ifms.Aeroporto.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.Aeroporto.dto.PassagemDto;
import br.edu.ifms.Aeroporto.model.Aviao;
import br.edu.ifms.Aeroporto.model.Passagem;
import br.edu.ifms.Aeroporto.service.PassagemService;

@RestController
@RequestMapping(value = "/passagem")
public class PassagemResource {
	
	@Autowired
	private PassagemService passagem;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Passagem> find(@PathVariable Integer id) {		
		Passagem obj = passagem.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PassagemDto objDto) {
		Passagem obj = passagem.fromDto(objDto);
		obj = passagem.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PassagemDto objDto, @PathVariable Integer id) {
		Passagem obj = passagem.fromDto(objDto);
		obj.setId(id);
		obj = passagem.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	//@RequestBody Aeroporto obj, @PathVariable(value = "id") Long noteId
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
		passagem.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Aviao obj,@PathVariable Integer id){
		passagem.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PassagemDto>> findAll() {		
		List<Passagem> list = passagem.findAll();
		List<PassagemDto> listDto = list.stream().map(obj -> new PassagemDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
