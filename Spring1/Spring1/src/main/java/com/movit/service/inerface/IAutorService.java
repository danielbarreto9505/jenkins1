package com.movit.service.inerface;

import java.util.List;

import org.springframework.data.domain.Page;

import com.movit.dto.AutorDto;
import com.movit.entity.Autor;
import com.movit.entity.Vista;

public abstract interface IAutorService extends ICrud<Autor, Integer>{

	public Page<Autor> listarPaginado(boolean lazy, int page, int size);
	
	public Autor listarPorId(boolean lazy, Integer id);
	
	//public void guardar( Autor autor);
	
	//public void editar( Autor autor);
	
	//public void eliminar(Integer idAutor);
	
	public void eliminarNoCascada(Integer idAutor);
	public List<Vista>  vista();
}
