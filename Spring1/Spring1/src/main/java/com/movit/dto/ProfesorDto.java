package com.movit.dto;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel(description = "Información de la persona")
public class ProfesorDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@ApiModelProperty(notes = "Edad debe ser entre 18 y 60")
	@NotNull(message = "Nombre es campo obligatorio")
	@Size(min = 2,  max = 25, message = "Nombre entre 2 y 25 carácteres")
	private String nombre;

	@NotNull
	@Size(min = 2,  max = 25,  message = "Apellido entre 2 y 25 carácteres")	
	private String apellido;
	
	@NotNull
	@Min(value = 18, message = "Edad mínima es 18")
	private Integer edad;
	
	@AssertTrue
	Boolean isUnsupported;

	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param edad
	 */
	public ProfesorDto(String nombre, String apellido, Integer edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
		
	public Integer getId() {
		return id;
	}

	/**
	 * Set del método id
	 * @param id retorna id
	 */
	public void setId(Integer id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Boolean isUnsupported() {
		return isUnsupported;
	}

	public void setUnsupported(Boolean isUnsupported) {
		this.isUnsupported = isUnsupported;
	}
	
	
		
	
}
