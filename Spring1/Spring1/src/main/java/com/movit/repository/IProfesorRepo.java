package com.movit.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movit.entity.Profesor;

@Repository
public interface IProfesorRepo extends JpaRepository<Profesor, Integer>{
	
	
	@Query(value = "SELECT p FROM Profesor p WHERE p.cedula = :cedula")
	public Profesor buscarPorCedula(String cedula);
	
	public Profesor findByCedula(String cedula);
	
	public Page<Profesor> findByNombre(String nombre, Pageable pageable);
	
	@Query(value = "SELECT p FROM Profesor p WHERE p.nombre = :nombre AND p.apellido = :apellido")
	public Page<Profesor> buscarPorNombreApellido(String nombre, String apellido, Pageable pageable);
	
	
}
