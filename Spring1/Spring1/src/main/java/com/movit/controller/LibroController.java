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

import com.movit.dto.LibroDto;
import com.movit.entity.Autor;
import com.movit.entity.Libro;
import com.movit.service.inerface.ILibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {

	@Autowired
	private ILibroService service;
	
	
	@GetMapping("/listarPageable/{lazy}/{page}/{size}")
	public  ResponseEntity<Page<Libro>> rentorPageable(@PathVariable boolean lazy, @PathVariable int page, @PathVariable int size) {		
		Page<Libro> listarLibro = service.listarPaginado(lazy, page, size);
		return new ResponseEntity<Page<Libro>>(listarLibro, HttpStatus.OK);
	}
	
	
	@GetMapping("/listar/{lazy}/{id}")
	public ResponseEntity<Libro> listarPorId(@PathVariable boolean lazy, @PathVariable int id)  {
		Libro libro = service.listarPorId(lazy, id);
			return new ResponseEntity<Libro>(libro, HttpStatus.OK);					
	}
	
	@PostMapping("/guardar")
	//public ResponseEntity<Object> guardar(@Valid @RequestBody LibroDto libro) {
	public ResponseEntity<Object> guardar(@Valid @RequestBody Libro libro) {
		service.guardar(libro);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@Valid @RequestBody Libro obj) {
		service.editar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/eliminar/{idLibro}")
	public ResponseEntity<Autor> eliminar(@PathVariable int idLibro)  {
			service.eliminar(idLibro);
			return new ResponseEntity<Autor>(HttpStatus.NO_CONTENT);					
	}
	
	
}
