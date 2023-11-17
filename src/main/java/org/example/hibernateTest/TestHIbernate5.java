package org.example.hibernateTest;

import org.example.hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHIbernate5 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 4);
//            session.delete(employee);
            session.createQuery("delete Employee where name = 'Elena'").executeUpdate();

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
