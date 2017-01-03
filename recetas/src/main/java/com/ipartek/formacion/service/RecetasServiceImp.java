package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipartek.formacion.dao.persistence.Recetas;
import com.ipartek.formacion.service.interfaces.RecetasService;

@Service
public class RecetasServiceImp implements RecetasService {

	@Transactional
	public void addRecetas(Recetas receta) {
		this.addRecetas(receta);
		
	}

	@Transactional
	public void updateReceta(Recetas receta) {
		this.updateReceta(receta);
		
	}

	@Transactional
	public List<Recetas> listaRecetas() {
		return this.listaRecetas();
	}

	@Transactional
	public Recetas getRecetaById(int id) {
		return this.getRecetaById(id);
	}

	@Transactional
	public void removeReceta(int id) {
		this.removeReceta(id);
		
	}

}
