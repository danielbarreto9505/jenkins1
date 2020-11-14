package com.movit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movit.entity.Libro;

@Repository
public interface ILibroRepo extends JpaRepository<Libro, Integer> {
	@Query(value = "select count(*) from public.libro where nombre = :nombre and id != :id", nativeQuery = true)				
	Object validarExistenciaNombreEditar(@Param("id") Integer id, @Param("nombre") String nombre);

}
