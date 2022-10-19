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

import br.edu.ifms.Aeroporto.dto.AviaoDto;
import br.edu.ifms.Aeroporto.model.Aviao;
import br.edu.ifms.Aeroporto.service.AviaoService;

@RestController
@RequestMapping(value = "/aviao")
public class AviaoResource {

	@Autowired
	private AviaoService aviao;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aviao> find(@PathVariable Integer id) {		
		Aviao obj = aviao.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AviaoDto objDto) {
		Aviao obj = aviao.fromDto(objDto);
		obj = aviao.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AviaoDto objDto, @PathVariable Integer id) {
		Aviao obj = aviao.fromDto(objDto);
		obj.setId(id);
		obj = aviao.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	//@RequestBody Aeroporto obj, @PathVariable(value = "id") Long noteId
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
		aviao.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Aviao obj,@PathVariable Integer id){
		aviao.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AviaoDto>> findAll() {		
		List<Aviao> list = aviao.findAll();
		List<AviaoDto> listDto = list.stream().map(obj -> new AviaoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
