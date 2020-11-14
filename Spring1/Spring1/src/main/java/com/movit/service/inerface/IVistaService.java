package com.movit.service.inerface;

import org.springframework.data.domain.Page;

import com.movit.entity.Autor;
import com.movit.entity.Vista;


public abstract interface IVistaService extends ICrud<Vista, Integer>{

		public Page<Vista> listarPaginado();
		
}
