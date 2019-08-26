package com.asm.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static Session session;
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure()
                    .buildSessionFactory();
            session = sessionFactory.openSession();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession(){
        if(!session.isOpen() || session == null){
            session = sessionFactory.openSession();
        }
        return session;
    }

}
