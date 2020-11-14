package com.movit.service.inerface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.movit.dto.ProfesorDto;
import com.movit.entity.Profesor;

public abstract interface IProfesorService extends ICrud<Profesor, Integer>{
	
	public List<Profesor> listar();
	
	public Page<Profesor> listarPaginado(int page, int size);
	
	public Profesor listarPorId(Integer id);
	
	public Page<Profesor> listarPorNombre(int page, int size, String nombre);
	
	public Page<Profesor> buscarPorNombreApellido(int page, int size, String nombre, String apellido);
	
	//public void guardar( Profesor profesor);
	
	//public void editar( Profesor profesor);
	
	//public void eliminar(Integer idProfesor);

}
