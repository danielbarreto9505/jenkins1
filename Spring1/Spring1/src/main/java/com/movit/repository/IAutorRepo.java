package com.movit.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movit.entity.Autor;

@Repository
public interface IAutorRepo extends JpaRepository<Autor, Integer> {
	
	@Query(value = "select count(*) from public.autor where cedula = :cedula", nativeQuery = true)				
	Object validarExistenciaCedula(@Param("cedula") String cedula);
	
	@Query(value = "select count(*) from public.autor where cedula = :cedula and id != :id", nativeQuery = true)				
	Object validarExistenciaCedulaEditar(@Param("id") Integer id, @Param("cedula") String cedula);
	
	@Query(value = "SELECT count(a) FROM Autor a WHERE a.Id = :id")
	BigInteger validarExistenciaPorId(@Param("id") Integer id);
	
	Autor findByCedula(String cedula);
	
	Autor findByLibro_NombreIgnoreCase(String nombre);
	
	

}
