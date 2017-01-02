package com.ipartek.formacion.dao.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.bson.types.ObjectId;
 
/** 
 * @author Josu
 */
@Entity
@Table(name = "recetas")
public class Recetas implements Serializable{
	
	@Id
    private String id;
    private String titulo;
    private float complejidad;
    private int gorrones;
    //private List<String> ingredientes;
    private String receta;
    //private Object multimedia;
    private float precio;
	/**
	 * @param id
	 * @param titulo
	 * @param complejidad
	 * @param gorrones
	 * @param ingredientes
	 * @param receta
	 * @param multimedia
	 * @param precio
	 */
	public Recetas(String id, String titulo, float complejidad, int gorrones, /*List<String> ingredientes,*/ String receta,
			/*Object multimedia,*/ float precio) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.complejidad = complejidad;
		this.gorrones = gorrones;
		//this.ingredientes = ingredientes;
		this.receta = receta;
		//this.multimedia = multimedia;
		this.precio = precio;
	}
	/**
	 * 
	 */
	public Recetas() {
		super();
		this.id = "";
		this.titulo = "";
		this.complejidad = 0;
		this.gorrones = 1;
		//this.ingredientes = new Ingredientes();
		this.receta = "";
		//this.multimedia = new Object();
		this.precio = 0;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public float getComplejidad() {
		return complejidad;
	}
	public void setComplejidad(float complejidad) {
		this.complejidad = complejidad;
	}
	public int getGorrones() {
		return gorrones;
	}
	public void setGorrones(int gorrones) {
		this.gorrones = gorrones;
	}
//	public List<String> getIngredientes() {
//		return ingredientes;
//	}
//	public void setIngredientes(List<String> ingredientes) {
//		this.ingredientes = ingredientes;
//	}
	public String getReceta() {
		return receta;
	}
	public void setReceta(String receta) {
		this.receta = receta;
	}
//	public Object getMultimedia() {
//		return multimedia;
//	}
//	public void setMultimedia(Object multimedia) {
//		this.multimedia = multimedia;
//	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
    
	@Override
    public String toString() {
        return "Datos Receta [id=" + id + ", Titulo=" + titulo + ", Complejidad=" + complejidad + ", "
        		+ "Comensales=" + gorrones + ", Ingredientes=" /*+ ingredientes*/ + ", Receta=" + receta + ", "
        				+ "Links multimedia=" /*+ multimedia*/ + ", Precio aproximado de la receta=" + precio + "]";
    }

}
