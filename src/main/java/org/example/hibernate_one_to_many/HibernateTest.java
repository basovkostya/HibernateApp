package org.example.hibernate_one_to_many;

import org.example.hibernate_one_to_many.entity.Department;
import org.example.hibernate_one_to_many.entity.Employee;
import org.example.hibernate_one_to_one.entity.Details;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            Department department = new Department("HR", 200, 2000);
            Employee employee1 = new Employee("Elena", "Sidorova", 750);
            Employee employee2 = new Employee("Kostya", "Basov", 750);
            Employee employee3 = new Employee("Anton", "Petrov", 62);
            department.AddEmployeeToDepartment(employee1);
            department.AddEmployeeToDepartment(employee2);
            department.AddEmployeeToDepartment(employee3);
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
