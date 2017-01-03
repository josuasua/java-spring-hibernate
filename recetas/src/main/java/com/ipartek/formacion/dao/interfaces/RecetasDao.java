package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Recetas;

public interface RecetasDao {
	
	public void addRecetas(Recetas receta);
	public void updateReceta(Recetas receta);
	public List<Recetas> listaRecetas();
	public Recetas getRecetaById(int id);
	public void removeReceta(int id);

}
