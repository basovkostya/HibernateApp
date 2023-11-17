package org.example.hibernate_one_to_one;

import org.example.hibernate_one_to_one.entity.Details;
import org.example.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHIbernate2 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Employee.class).addAnnotatedClass(Details.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
//            Employee employee = new Employee("Elena", "Sidorova", "Sales", 750);
//            Details details = new Details("Moscow", "+5287587585", "mlena@mail.ru");
//            details.setEmployee(employee);
//            employee.setEmpDetails(details);


            session.beginTransaction();
            Details details = session.get(Details.class, 1);
            details.getEmployee().setEmpDetails(null);
            session.delete(details);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
