package com.movit.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class DireccionDto {
	
	
	@NotNull
	@Size(min = 3,max = 30, message = "La descripcion debe ser entre 3 y 30 carácteres")	
	private String descripcion;	
	
	@NotNull
	@Size(min = 3,max = 12, message = "El barrio debe ser entre 3 y 12 carácteres")	
	private String barrio;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	
	

}
