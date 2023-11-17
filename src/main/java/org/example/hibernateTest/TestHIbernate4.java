package org.example.hibernateTest;

import org.example.hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestHIbernate4 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 0);
//            employee.setSalary(5000);
            session.createQuery("update Employee Set salary=500 where name = 'Elena'").executeUpdate();

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
