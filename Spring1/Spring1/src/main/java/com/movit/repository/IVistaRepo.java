package com.movit.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movit.entity.Autor;
import com.movit.entity.Vista;


@Repository
@Transactional
public interface IVistaRepo extends JpaRepository<Vista, String> {
	
}
