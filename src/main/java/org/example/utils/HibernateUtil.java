package org.example.utils;

import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final HibernateUtil INSTANCE = new HibernateUtil();

    private final SessionFactory sessionFactory;

    private HibernateUtil() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        sessionFactory.close();
    }
}