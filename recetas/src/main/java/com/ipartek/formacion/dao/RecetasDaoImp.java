package com.ipartek.formacion.dao;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ipartek.formacion.dao.interfaces.RecetasDao;
import com.ipartek.formacion.dao.persistence.Recetas;


@Repository
public class RecetasDaoImp implements RecetasDao {

	private static final Logger logger = LoggerFactory.getLogger(RecetasDaoImp.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public void addRecetas(Recetas receta) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(receta);
		logger.info("Se ha añadido la receta" + receta.getTitulo());
	}

	public void updateReceta(Recetas receta) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(receta);
		logger.info("Se ha actualizado la receta" + receta.getTitulo());
	}

	@SuppressWarnings("unchecked")
	public List<Recetas> listaRecetas() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Recetas> listaRecetas = session.createQuery("from recetas").list();
		for(Recetas receta : listaRecetas){
			logger.info("Lista de recetas");
		}
		return listaRecetas;
	}

	public Recetas getRecetaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Recetas receta = (Recetas) session.load(Recetas.class, new Integer(id));
		logger.info("Mostrar receta por ID: "+ receta.getTitulo());
		return receta;
	}

	public void removeReceta(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Recetas receta = (Recetas) session.load(Recetas.class, new Integer(id));
		if(null != receta){
			session.delete(receta);
		}
		logger.info("Se ha eliminado la "+receta.getTitulo());
	}
}
