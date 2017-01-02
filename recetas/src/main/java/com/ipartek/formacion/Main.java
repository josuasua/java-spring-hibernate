package com.ipartek.formacion;

import org.hibernate.SessionFactory;

import com.ipartek.formacion.dao.persistence.HibernateUtil;
import com.ipartek.formacion.dao.persistence.Recetas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
		
		Recetas recetas = new Recetas();
		

        if(!sessionFactory.isClosed())
        {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("SessionFactory is Still Open!! Now Attempting to close the SessionFactory");
            System.out.println("-------------------------------------------------------------------------");
            sessionFactory.close();
        }
        

        System.exit(0);
	}

}
