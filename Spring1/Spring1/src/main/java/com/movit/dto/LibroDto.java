package com.movit.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LibroDto {
	
	private Integer Id;
	
	@NotNull
	@Size(min = 5,max = 25, message = "El nombre debe ser entre 5 y 25 carácteres")	
	private String nombre;
	
	@NotNull
	@Min(value = 5, message = "Debe tener mínimo 5 páginas")		
	private Integer numeroPaginas;
	
	private AutorDto autor;
	

	public Integer getId() {
		return Id;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public AutorDto getAutor() {
		return autor;
	}

	public void setAutor(AutorDto autor) {
		this.autor = autor;
	}		

}
