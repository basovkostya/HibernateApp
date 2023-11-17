package org.example.hibernateTest;

import org.example.hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate2 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            Employee employee = new Employee("Oleg", "Sidorov", "Sales", 50);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee1 = session.get(Employee.class, 2);
            session.getTransaction().commit();
            System.out.println(employee1);
        } finally {
            sessionFactory.close();
        }
    }
}
