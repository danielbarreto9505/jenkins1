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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "direccion")
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer Id;
	
	@NotNull
	@Size(min = 3,max = 50, message = "La descripcion debe ser entre 3 y 50 carácteres")	
	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;	
	
	@NotNull
	@Size(min = 3,max = 12, message = "El barrio debe ser entre 3 y 12 carácteres")	
	@Column(name = "barrio", nullable = false, length = 12)
	private String barrio;
	
	@OneToOne
	@MapsId
	private Autor autor;

	public Integer getId() {
		return Id;
	}

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

	@JsonIgnore
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public void setId(Integer id) {
		Id = id;
	}

	
		
	
		
}
