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

import br.edu.ifms.Aeroporto.dto.PassageiroDto;
import br.edu.ifms.Aeroporto.model.Aviao;
import br.edu.ifms.Aeroporto.model.Passageiro;
import br.edu.ifms.Aeroporto.service.PassageiroService;

@RestController
@RequestMapping(value = "/passageiro")
public class PassageiroResource {

	@Autowired
	private PassageiroService passageiro;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Passageiro> find(@PathVariable Integer id) {		
		Passageiro obj = passageiro.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PassageiroDto objDto) {
		Passageiro obj = passageiro.fromDto(objDto);
		obj = passageiro.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PassageiroDto objDto, @PathVariable Integer id) {
		Passageiro obj = passageiro.fromDto(objDto);
		obj.setId(id);
		obj = passageiro.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	//@RequestBody Aeroporto obj, @PathVariable(value = "id") Long noteId
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
		passageiro.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Aviao obj,@PathVariable Integer id){
		passageiro.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PassageiroDto>> findAll() {		
		List<Passageiro> list = passageiro.findAll();
		List<PassageiroDto> listDto = list.stream().map(obj -> new PassageiroDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
