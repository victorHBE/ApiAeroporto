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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.Aeroporto.dto.VooDto;
import br.edu.ifms.Aeroporto.model.Aviao;
import br.edu.ifms.Aeroporto.model.Voo;
import br.edu.ifms.Aeroporto.service.VooService;

public class VooResource {

	@Autowired
	private VooService voo;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Voo> find(@PathVariable Integer id) {		
		Voo obj = voo.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody VooDto objDto) {
		Voo obj = voo.fromDto(objDto);
		obj = voo.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody VooDto objDto, @PathVariable Integer id) {
		Voo obj = voo.fromDto(objDto);
		obj.setId(id);
		obj = voo.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	//@RequestBody Aeroporto obj, @PathVariable(value = "id") Long noteId
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
		voo.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Aviao obj,@PathVariable Integer id){
		voo.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<VooDto>> findAll() {		
		List<Voo> list = voo.findAll();
		List<VooDto> listDto = list.stream().map(obj -> new VooDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
