package com.ipartek.formacion.dao.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.ogm.cfg.OgmConfiguration;
import org.hibernate.service.ServiceRegistry;

import com.ipartek.formacion.dao.persistence.recetas;

public class hibernateUtil {  
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() 
    {
        if (sessionFactory == null) 
        {
             Configuration cfgogm = new OgmConfiguration().configure();
              ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(cfgogm.getProperties()).build();

             cfgogm.addAnnotatedClass(recetas.class);
            sessionFactory = cfgogm.buildSessionFactory(serviceRegistry);   
            sessionFactory.getStatistics().setStatisticsEnabled(Boolean.TRUE);
        }
        else
        {
            System.out.println("SessionFactory is not Null");
        }
        System.out.println(sessionFactory);
        return sessionFactory;
    }
       public static void main(String[] args)
    {

        SessionFactory sessionFactory = new hibernateUtil().getSessionFactory();

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
