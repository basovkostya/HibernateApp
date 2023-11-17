package org.example.hibernate_one_to_one;

import org.example.hibernate_one_to_one.entity.Details;
import org.example.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHIbernate {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Employee.class).addAnnotatedClass(Details.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
//            Employee employee = new Employee("Sasha", "Koltsov", "Zavod", 50);
//            Details details = new Details("Yo", "+5551666", "sahs04@mail.ru");
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 2);

            session.delete(employee);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
