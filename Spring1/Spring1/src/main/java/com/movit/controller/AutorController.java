package com.movit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movit.entity.Autor;
import com.movit.entity.Direccion;
import com.movit.entity.Vista;
import com.movit.service.inerface.IAutorService;
import com.movit.service.inerface.IDireccionService;


@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private IAutorService service;
	

	@Autowired
	private IDireccionService servicee;
	
	
	@GetMapping("/listarPageable/{lazy}/{page}/{size}")
	public  ResponseEntity<Page<Autor>> rentorPageable(@PathVariable boolean lazy, @PathVariable int page, @PathVariable int size) {		
		Page<Autor> listarAutor = service.listarPaginado(lazy, page, size);
		return new ResponseEntity<Page<Autor>>(listarAutor, HttpStatus.OK);
	}
	
	
	@GetMapping("/listar/{lazy}/{id}")
	public ResponseEntity<Autor> listarPorId(@PathVariable boolean lazy, @PathVariable int id)  {
			Autor autor = service.listarPorId(lazy, id);
			return new ResponseEntity<Autor>(autor, HttpStatus.OK);					
	}
		
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardar(@Valid @RequestBody Autor obj) {
		service.guardar(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@Valid @RequestBody Autor obj) {
		service.editar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	//get vista
	@GetMapping("/vista")
	public ResponseEntity<Object> vista() {
		Object object = service.vista();
		
		return new ResponseEntity<Object>(object, HttpStatus.OK);
	}
	
	
	
	
	
	@DeleteMapping("/eliminar/{idAutor}")
	public ResponseEntity<Autor> eliminar(@PathVariable int idAutor)  {
			service.eliminar(idAutor);
			return new ResponseEntity<Autor>(HttpStatus.NO_CONTENT);					
	}
	
	@PutMapping("/editarquery")
	public ResponseEntity<Object> editarQuery(@Valid @RequestBody Direccion direccion){
		servicee.editarquery(direccion);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PutMapping("/editar3")
	public ResponseEntity<Object> editardir(@Valid @RequestBody Direccion direccion){
		servicee.editar(direccion);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	

}
