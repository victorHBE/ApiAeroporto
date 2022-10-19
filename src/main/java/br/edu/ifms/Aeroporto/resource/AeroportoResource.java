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

import br.edu.ifms.Aeroporto.dto.AeroportoDto;
import br.edu.ifms.Aeroporto.model.Aeroporto;
import br.edu.ifms.Aeroporto.service.AeroportoService;

@RestController
@RequestMapping(value = "/aeroporto")
public class AeroportoResource {
	
	@Autowired
	private AeroportoService aeroporto;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aeroporto> find(@PathVariable Integer id) {		
		Aeroporto obj = aeroporto.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AeroportoDto objDto) {
		Aeroporto obj = aeroporto.fromDto(objDto);
		obj = aeroporto.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AeroportoDto objDto, @PathVariable Integer id) {
		Aeroporto obj = aeroporto.fromDto(objDto);
		obj.setId(id);
		obj = aeroporto.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	//@RequestBody Aeroporto obj, @PathVariable(value = "id") Long noteId
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
		aeroporto.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Aeroporto obj,@PathVariable Integer id){
		aeroporto.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AeroportoDto>> findAll() {		
		List<Aeroporto> list = aeroporto.findAll();
		List<AeroportoDto> listDto = list.stream().map(obj -> new AeroportoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
