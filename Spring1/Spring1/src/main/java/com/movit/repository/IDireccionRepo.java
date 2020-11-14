package com.movit.repository;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movit.entity.Direccion;

@Repository
public interface IDireccionRepo extends JpaRepository<Direccion, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE direccion SET barrio= :barrio, descripcion= :descripcion WHERE autor_id= :autorid", nativeQuery = true)
	public void editarquery(
			@Param("autorid") Integer idAutor,
			@Param("descripcion") String descripcion,
			@Param("barrio") String barrio);
			
}
