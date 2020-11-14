package com.movit.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.movit.entity.Autor;
import com.movit.entity.Libro;
import com.movit.entity.Vista;
import com.movit.exception.ArgumentRequiredException;
import com.movit.exception.BusinessLogicException;
import com.movit.exception.ModelNotFoundException;
import com.movit.repository.IAutorRepo;
import com.movit.repository.IVistaRepo;
import com.movit.service.inerface.IAutorService;

@Service
public class AutorServiceImp implements IAutorService {

	@Autowired
	private IAutorRepo repo;
	@Autowired
	private IVistaRepo repov;


	@Override
	public Page<Autor> listarPaginado(boolean lazy, int page, int size) {
		Page<Autor> listaPaginaAutor = repo.findAll(PageRequest.of(page, size, Sort.by("nombre").ascending()));
		;

		if (lazy) {
			for (Autor autor : listaPaginaAutor.getContent()) {
				autor.setLibro(null);
			}
		}

		return listaPaginaAutor;
	}

	@Override
	public Autor listarPorId(boolean lazy, Integer id) {
		Autor autor = repo.findById(id).orElseThrow(() -> new ModelNotFoundException("Autor no encontrado"));

		if (lazy) {
			autor.setLibro(null);
		}
		return autor;
	}

	@Override
	public void guardar(Autor autor) {

		BigInteger contador = (BigInteger) repo.validarExistenciaCedula(autor.getCedula());
		if (contador.intValue() > 0)
			throw new BusinessLogicException("Ya existe un Autor con esta cédula");

		if (autor.getLibro() != null) {
			for (Libro libro : autor.getLibro()) {
				libro.setAutor(autor);
			}
		}
		repo.save(autor);
	}

	@Override
	public void editar(Autor obj) {

		if (obj.getId() == null)
			throw new ArgumentRequiredException("Id Autor es requerido");

		Autor autor = repo.findById(obj.getId()).orElseThrow(() -> new ModelNotFoundException("Autor no encontrado"));

		BigInteger contador = (BigInteger) repo.validarExistenciaCedulaEditar(obj.getId(), obj.getCedula());

		if (contador.intValue() > 0)
			throw new BusinessLogicException("Ya existe un Autor con esta cédula");

		autor.setCedula(obj.getCedula());
		autor.setApellido(obj.getApellido());
		autor.setNombre(obj.getNombre());
		autor.setFechaNacimiento(obj.getFechaNacimiento());

		// autor.setLibro(obj.getLibro());
		// autor.getLibro().get(0).setNombre("cambio de libro");

		repo.save(autor);
	}

	@Override
	public void eliminar(Integer idAutor) {
		repo.existsById(idAutor);
		repo.deleteById(idAutor);
	}

	@Override
	public void eliminarNoCascada(Integer idAutor) {
		Autor autor = repo.findById(idAutor).orElseThrow(() -> new ModelNotFoundException("Autor no encontrado"));

		if (autor.getLibro() != null && autor.getLibro().size() > 0)
			new BusinessLogicException("Se debe eliminar primero los libros para poder eliminar el Autor");

		repo.delete(autor);
	}

	@Override
	public List<Vista>  vista() {
		List<Vista> listado=repov.findAll();
		System.out.println(listado);
		return listado;
		
	
	}
}
