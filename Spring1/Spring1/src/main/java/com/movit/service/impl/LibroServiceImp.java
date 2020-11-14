package com.movit.service.impl;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.movit.dto.LibroDto;
import com.movit.entity.Autor;
import com.movit.entity.Libro;
import com.movit.exception.ArgumentRequiredException;
import com.movit.exception.BusinessLogicException;
import com.movit.exception.ModelNotFoundException;
import com.movit.repository.IAutorRepo;
import com.movit.repository.ILibroRepo;
import com.movit.service.inerface.ILibroService;

@Service
public class LibroServiceImp implements ILibroService{

	@Autowired
	private ILibroRepo repo;
	
	@Autowired
	private IAutorRepo repoAutor;
	
	@Override
	public Page<Libro> listarPaginado(boolean lazy, int page, int size) {
		Page<Libro> listaPaginaLibro = repo.findAll(PageRequest.of(page, size, Sort.by("nombre").ascending()));;
		return listaPaginaLibro;
	}

	@Override
	public Libro listarPorId(boolean lazy, Integer id) {
		Libro libro = repo.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Libro no encontrado"));	

		return libro;
	}

	@Override
	public void guardar(Libro libro) {
		if(libro.getAutor() != null && libro.getAutor().getId() != null) {
			if(repoAutor.existsById(libro.getAutor().getId())) {
				repo.save(libro);
			} else
				throw new ModelNotFoundException("No existe el autor");
		}
		else 
			throw new ArgumentRequiredException("El id del autor es requerido");
	}

	@Override
	public void editar(Libro obj) {
		
		if(obj.getId() == null)
			throw new ArgumentRequiredException("Id Autor es requerido");
		
		Libro libro = repo.findById(obj.getId()).orElseThrow(() 
				-> new ModelNotFoundException("Autor no encontrado"));	
		
		BigInteger contador  = (BigInteger) repo.validarExistenciaNombreEditar(obj.getId(), obj.getNombre());

		if(contador.intValue() > 0)
			throw new BusinessLogicException("Ya existe un libro con este nombre");
		
		
		libro.setNombre(obj.getNombre());
		libro.setNumeroPaginas(obj.getNumeroPaginas());
		Autor c = new Autor();
		libro.setId(obj.getId());
		
				

		//autor.setLibro(obj.getLibro());
		//autor.getLibro().get(0).setNombre("cambio de libro");
		
		repo.save(libro);		
	}
	
	
	@Override
	public void eliminar(Integer idLibro) {
		  try {
			  System.out.println(idLibro);
			  boolean flag = repo.existsById(idLibro);
		  } catch(Exception ex) {
			  System.out.println("Capturando");
			  throw new EmptyResultDataAccessException("Libro no encontrado", 0);
		  }
		  repo.deleteById(idLibro);		
	}

}
