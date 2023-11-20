package org.example.hibernate_many_to_one;

import org.example.hibernate_many_to_one.entity.Department;

import org.example.hibernate_many_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
//            Employee employee1 = new Employee("Bob", "Pavlov", 450);
//            Employee employee2 = new Employee("Mike", "Egorov", 1500);
//            Department department = new Department("HR", 200, 2000);
//            department.AddEmployeeToDepartment(employee1);
//            department.AddEmployeeToDepartment(employee2);
              session.beginTransaction();

            Employee employee = session.get(Employee.class, 3);
//            Department department = session.get(Department.class, 4);
//;

            session.delete(employee);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
