package org.example.hibernateTest;

import org.example.hibernateTest.entity.Employee;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.naming.CompositeName;

public class TestHIbernate {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            Employee employee = new Employee("Misha", "Pushkarev", "IT", 1250);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
