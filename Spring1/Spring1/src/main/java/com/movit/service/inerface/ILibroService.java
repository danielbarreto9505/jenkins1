package com.movit.service.inerface;

import org.springframework.data.domain.Page;

import com.movit.dto.LibroDto;
import com.movit.entity.Libro;

public abstract interface ILibroService extends ICrud<Libro, Integer>{

	public Page<Libro> listarPaginado(boolean lazy, int page, int size);
	
	public Libro listarPorId(boolean lazy, Integer id);
	
	//public void guardar( LibroDto libro);
	
	//public void editar( Libro libro);
	
	//public void eliminar(Integer idLibro);
		
		
	
}
