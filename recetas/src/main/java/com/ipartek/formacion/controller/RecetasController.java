package com.ipartek.formacion.controller;

import com.ipartek.formacion.dao.persistence.Recetas;
import com.ipartek.formacion.service.interfaces.RecetasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecetasController {

private RecetasService recetasService;
	
	@Autowired(required=true)
	@Qualifier(value="recetasService")
	public void setRecetaService(RecetasService rS){
		this.recetasService = rS;
	}
	
	@RequestMapping(value = "/recetas", method = RequestMethod.GET)
	public String listaRecetas(Model model) {
		model.addAttribute("receta", new Recetas());
		model.addAttribute("listaRecetas", this.recetasService.listaRecetas());
		return "receta";
	}
	
	//For add and update person both
	@RequestMapping(value= "/recetas/add", method = RequestMethod.POST)
	public String addReceta(@ModelAttribute("receta") Recetas receta){
		
		if(receta.getId() == ""){
			//new person, add it
			this.recetasService.addRecetas(receta);
		}else{
			//existing person, call update
			this.recetasService.updateReceta(receta);
		}
		
		return "redirect:/recetas";
		
	}
	
	//Remove se anula, ETL, nada de borrar.
//	@RequestMapping("/remove/{id}")
//    public String removeReceta(@PathVariable("id") int id){
//		
//        this.recetasService.removeReceta(id);
//        return "redirect:/recetas";
//    }
 
    @RequestMapping("/edit/{id}")
    public String editReceta(@PathVariable("id") int id, Model model){
        model.addAttribute("receta", this.recetasService.getRecetaById(id));
        model.addAttribute("listaRecetas", this.recetasService.listaRecetas());
        return "receta";
    }
}
