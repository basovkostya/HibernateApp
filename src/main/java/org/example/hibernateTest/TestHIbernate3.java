package org.example.hibernateTest;

import org.example.hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestHIbernate3 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();
//            List<Employee> employeeList = session.createQuery("from Employee").getResultList();//в HQL запросе пишем имя класса и поля а не таблицы
            List<Employee> employeeList = session.createQuery("from Employee where name='Oleg' and salary = 50").getResultList();
            for (Employee e: employeeList)
                System.out.println(e);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
