package com.movit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min = 7,  max = 10,  message = "Cédula entre 7 y 10 números")		
	@Column(name = "cedula", nullable = false, length = 10, unique = true)
	private String cedula;
	
	@NotNull
	@Size(min = 3,  max = 25,  message = "Nombre entre 3 y 25 carácteres")		
	@Column(name = "nombre", nullable = false, length = 25)
	private String nombre;
	
	@NotNull
	@Size(min = 3,  max = 25,  message = "Apellido entre 3 y 25 carácteres")		
	@Column(name = "apellido", nullable = false, length = 25)
	private String apellido;
	
	@NotNull
	@Min(value = 18, message = "Edad mayor a 18")
	@Column(name = "edad", nullable = false)
	private Integer edad;
	
	@NotNull
	@Size(min = 8,max = 60, message = "El correo debe ser mayor de 8 letras y no debe exceder 60.")
	@Email(message = "El correo debe tener el formato correcto. Ejemplo:correo@hotmail.com")	
	@Column(name = "correo", nullable = false, length = 60)
	private String correo;
	
	
		

	public Integer getId() {
		return id;
	}

	public String getCedula() {
		return cedula;
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

	public String getCorreo() {
		return correo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public void setCorreo(String correo) {
		this.correo = correo;
	}	

}
