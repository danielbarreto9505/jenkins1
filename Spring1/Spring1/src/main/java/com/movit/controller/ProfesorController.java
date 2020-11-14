package com.movit.controller;

import java.util.List;

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

import com.movit.entity.Profesor;
import com.movit.service.inerface.IProfesorService;

/**
 * 
 * @author Johans González
 * @since 12/09/2020
 */
@RestController
@RequestMapping("/profesores")
public class ProfesorController {
	
	@Autowired
	IProfesorService service;
	
	/*@GetMapping(path = "/retornarTodos",  produces = "application/xml")
	//@RequestMapping(value = "/retornar", method = RequestMethod.GET)
	public  ResponseEntity<List<ProfesorDto>> retonarTodos() {
		List<ProfesorDto> lista = new ArrayList<>();
		ProfesorDto profesor = new ProfesorDto("Johans", "González", 30);
		//lista.add(profesor);
		//lista.add(profesor);
		
		if(lista.isEmpty()) {
			return new ResponseEntity<List<ProfesorDto>>(lista, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProfesorDto>>(lista, HttpStatus.OK);
	}	
	
	@GetMapping(path = "/retornar",  produces = "application/xml")
	//@RequestMapping(value = "/retornar", method = RequestMethod.GET)
	public  ResponseEntity<ProfesorDto> retonar() {
		ProfesorDto profesor = new ProfesorDto("Johans", "González", 30);		
		return new ResponseEntity<ProfesorDto>(profesor, HttpStatus.OK);
	}
	
	@GetMapping("/retornar/info/{edad}")
	//@RequestMapping(value = "/retornar", method = RequestMethod.GET)
	public  ResponseEntity<ProfesorDto> rentorInfo(@PathVariable int edad) {
		ProfesorDto profesor = new ProfesorDto("Johans", "González", edad);		
		profesor = null;
		if(profesor == null) {
			return new ResponseEntity<ProfesorDto>(profesor, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProfesorDto>(profesor, HttpStatus.OK);
	}
	
	
	@GetMapping("/retornar2/info/{edad}")
	//@RequestMapping(value = "/retornar", method = RequestMethod.GET)
	public ResponseEntity<ProfesorDto> rentorInfo2(@PathVariable int edad) {
		ProfesorDto profesor = new ProfesorDto("Johans", "González", edad);
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add("protocolo", "http");
		return new ResponseEntity<ProfesorDto>(profesor, cabecera, HttpStatus.OK);
	}	
	
	
	@PostMapping("/guardar")
	public ResponseEntity<ProfesorDto> guardar(@Valid @RequestBody ProfesorDto profesor) {
		profesor.setId(4);
		return new ResponseEntity<ProfesorDto>(profesor, HttpStatus.CREATED);	
		
	}
	
	/*@PostMapping("/guardar")
	public ResponseEntity<Object> guardar(@RequestBody ProfesorDto profesor) {
		profesor.setId(4);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}*/

	
	/*@PutMapping("/editar")
	public ResponseEntity<Object> editar(@RequestBody ProfesorDto profesor) {
		if(profesor.getId() == 4) {
			profesor.setEdad(28);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> elimianr(@PathVariable int id)  {
			service.eliminar(id);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);					
	}*/
	
	@GetMapping("/listar")
	public  ResponseEntity<List<Profesor>> rentorInfo() {		
		List<Profesor> listaProfesor = service.listar();
		return new ResponseEntity<List<Profesor>>(listaProfesor, HttpStatus.OK);
	}
	
	@GetMapping("/listarPorNombre/{page}/{size}/{nombre}")
	public  ResponseEntity<Page<Profesor>> rentorPorNombre(@PathVariable int page, @PathVariable int size, @PathVariable String nombre) {		
		Page<Profesor> listaProfesor = service.listarPorNombre(page, size, nombre);
		return new ResponseEntity<Page<Profesor>>(listaProfesor, HttpStatus.OK);
	}

	@GetMapping("/listarPorNombreApellido/{page}/{size}/{nombre}/{apellido}")
	public  ResponseEntity<Page<Profesor>> rentorPorNombreApellido(@PathVariable int page, @PathVariable int size, @PathVariable String nombre, @PathVariable String apellido) {		
		Page<Profesor> listaProfesor = service.buscarPorNombreApellido(page, size, nombre, apellido);
		return new ResponseEntity<Page<Profesor>>(listaProfesor, HttpStatus.OK);
	}
	
	
	@GetMapping("/listarPageable/{page}/{size}")
	public  ResponseEntity<Page<Profesor>> rentorPageable(@PathVariable int page, @PathVariable int size) {		
		Page<Profesor> listaProfesor = service.listarPaginado(page, size);
		return new ResponseEntity<Page<Profesor>>(listaProfesor, HttpStatus.OK);
	}
	
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Profesor> listarPorId(@PathVariable int id)  {
			Profesor profesor = service.listarPorId(id);
			return new ResponseEntity<Profesor>(profesor, HttpStatus.OK);					
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardar(@Valid @RequestBody Profesor obj) {
		service.guardar(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@Valid @RequestBody Profesor obj) {
		service.editar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> elimianr(@PathVariable int id)  {
			service.eliminar(id);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);					
	}
	
	
	

}
