package com.movit.service.inerface;

import org.springframework.data.domain.Page;

import com.movit.entity.Direccion;
import com.movit.entity.Libro;


public  interface IDireccionService{

	public void editar(Direccion direccion);
	
	public void editarquery(Direccion direccion);
		

}
