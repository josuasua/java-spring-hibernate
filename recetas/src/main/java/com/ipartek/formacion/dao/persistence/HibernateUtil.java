package com.ipartek.formacion.dao.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.ogm.cfg.OgmConfiguration;
import org.hibernate.service.ServiceRegistry;

import com.ipartek.formacion.dao.persistence.Recetas;

public class HibernateUtil {  
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() 
    {
        if (sessionFactory == null) 
        {
             Configuration cfgogm = new OgmConfiguration().configure();
              ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(cfgogm.getProperties()).build();

             cfgogm.addAnnotatedClass(Recetas.class);
            sessionFactory = cfgogm.buildSessionFactory(serviceRegistry);   
            sessionFactory.getStatistics().setStatisticsEnabled(Boolean.TRUE);
        }
        else
        {
            System.out.println("SessionFactory is not Null");
        }
        
      //  System.out.println(sessionFactory);
        System.out.println(sessionFactory.getStatistics());
        return sessionFactory;
    }
    
       
 }
