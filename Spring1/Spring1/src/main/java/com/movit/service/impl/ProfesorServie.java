package com.movit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.movit.entity.Profesor;
import com.movit.exception.ArgumentRequiredException;
import com.movit.exception.BusinessLogicException;
import com.movit.exception.ModelNotFoundException;
import com.movit.repository.IProfesorRepo;
import com.movit.service.inerface.IProfesorService;


@Service
public class ProfesorServie implements IProfesorService{

	@Autowired
	private IProfesorRepo repo;
	
	@Override
	public List<Profesor> listar() {	
		return repo.findAll();		
	}
	
	@Override
	public Page<Profesor> listarPaginado(int page, int size) {
		//return repo.findAll(PageRequest.of(page, size));	
		return repo.findAll(PageRequest.of(page, size, Sort.by("nombre").ascending()));
	}	
	
	@Override
	public Page<Profesor> listarPorNombre(int page, int size, String nombre) {
		return repo.findByNombre(nombre, PageRequest.of(page, size, Sort.by("apellido").ascending()));
	}
	
	@Override
	public Page<Profesor> buscarPorNombreApellido(int page, int size, String nombre, String apellido) { 
		return repo.buscarPorNombreApellido(nombre, apellido, PageRequest.of(page, size, Sort.by("cedula").ascending()));
	}
	
	

	@Override
	public Profesor listarPorId(Integer id) {
		Profesor profesor = repo.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Profesor no encontrado"));
		/*Optional<Profesor> opc = repo.findById(id);
		if(opc.isPresent()) 
			return opc.get();
		else
			throw new ModelNotFoundException("Profesor no encontrado");*/
		//return opc.isPresent() ? opc.get() : new Profesor();
		return profesor;
	}

	@Override
	public void guardar(Profesor profesor) {
		//Profesor obj = repo.buscarPorCedula(profesor.getCedula());
		Profesor obj = repo.findByCedula(profesor.getCedula());
		//Profesor obj = repo.buscar(sort)
		if(obj == null)
			repo.save(profesor);
		else
			throw new BusinessLogicException("Cédula ya se enecuntra registrada");
	}

	@Override
	public void editar(Profesor profesor) {
		if(profesor.getId() == null) {
			throw new ArgumentRequiredException("Id Profesor es requerido");
		}
		this.listarPorId(profesor.getId());
		repo.save(profesor);
	}

	@Override
	public void eliminar(Integer idProfesor) {
		this.listarPorId(idProfesor);
		repo.deleteById(idProfesor);
	}
	
}
