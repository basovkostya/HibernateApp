package org.example;

import antlr.collections.List;
import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
        session.beginTransaction();

        Person person = session.get(Person.class, 1);
            System.out.println("Получили чеовека");
           System.out.println(person.getItems());

        session.getTransaction().commit();
        }
        finally {
        sessionFactory.close();
        }
    }
}
