package com.movit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.movit.entity.Direccion;
import com.movit.entity.Libro;
import com.movit.exception.ArgumentRequiredException;
import com.movit.exception.ModelNotFoundException;
import com.movit.repository.IDireccionRepo;
import com.movit.repository.ILibroRepo;
import com.movit.service.inerface.IDireccionService;

@Service
public  class DireccionServiceImp implements IDireccionService{
	@Autowired
	private IDireccionRepo repo;
@Override
public void editar (Direccion direccion) {
	if(direccion.getId()==null)
	{
		throw new ArgumentRequiredException("id_direccion es requerido");
		
	}
	
	Direccion direccion1 =repo.findById(direccion.getId()).orElseThrow(()
			-> new ModelNotFoundException("Direccion no encontrada"));
	direccion1.setDescripcion(direccion.getDescripcion());
	direccion1.setBarrio(direccion.getBarrio());
	
	repo.save(direccion1);
	
	
}

@Override
public void editarquery(Direccion direccion) {
	if(direccion.getId()==null)
	{
		throw new ArgumentRequiredException("id_direccion es requerido");
		
	}
	boolean existente = repo.existsById(direccion.getId());
	 
	if(existente==false) {
		
		throw new ModelNotFoundException("libro not found");
	}else{
		repo.editarquery(direccion.getId(), direccion.getDescripcion(),direccion.getBarrio());
	}
	
}

}
