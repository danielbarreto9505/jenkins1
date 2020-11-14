package com.movit.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer Id;
	
	@NotNull
	@Size(min = 7,max = 11, message = "La cédula debe ser entre 7 y 11 carácteres")	
	@Column(name = "cedula", nullable = false, length = 11)
	private String cedula;	
	
	@NotNull
	@Size(min = 5,max = 25, message = "El nombre debe ser entre 5 y 25 carácteres")	
	@Column(name = "nombre", nullable = false, length = 25)
	private String nombre;
	
	@NotNull
	@Size(min = 5,max = 25, message = "El apellido debe ser entre 5 y 25 carácteres")		
	@Column(name = "apellido", nullable = false, length = 25)
	private String apellido;
	
	@NotNull(message = "fechaNacimiento es requerido")
	@Past(message = "La fecha debe ser menor a la fecha actual")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_nacimiento", nullable = false)
	private LocalDate fechaNacimiento;
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Libro> libro;
	
	@NotNull(message = "Direccion es requerido")
	@OneToOne(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Direccion direccion;

	public Integer getId() {
		return Id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Libro> getLibro() {
		return libro;
	}

	public void setLibro(List<Libro> libro) {
		this.libro = libro;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
		
	
		
}
