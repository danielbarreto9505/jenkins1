package com.movit.service.inerface;
import java.util.List;

import com.movit.entity.Profesor;

public interface ICrud <TDto, ID> {

	//public List<TDto> get();
	
	//public TDto getId(ID id);
	
	public void guardar(TDto objectSave);
	
	public void editar(TDto objectEdit);
	
	public void eliminar(ID id);

}
