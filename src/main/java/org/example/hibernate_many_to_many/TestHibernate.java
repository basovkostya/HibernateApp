package org.example.hibernate_many_to_many;

import org.example.hibernate_many_to_many.entity.Child;
import org.example.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Child.class).addAnnotatedClass(Section.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
           session.beginTransaction();
//           Section section = new Section("Football");
//           Child child1 = new Child("Masha", 12);
//           Child child2 = new Child("Kostya", 33);
//            Child child3 = new Child("Oleg", 34);
//            section.AddChildToSection(child1);
//            section.AddChildToSection(child2);
//            section.AddChildToSection(child3);
//            session.save(section);

//            Section section1 = new Section("Java");
//            Section section2 = new Section("Math");
//            Section section3 = new Section("VolleyBall");
//            Child child1 = new Child("Igor", 25);
//            child1.AddSection(section1);
//            child1.AddSection(section2);
//            child1.AddSection(section3);
//            session.save(child1);

//            Section section1 = session.get(Section.class, 1);
//            System.out.println(section1.getChildList());

            Child child = session.get(Child.class, 10);
//            System.out.println(child.getSectionList());
//            Section section = session.get(Section.class, 5);
            session.remove(child);
            session.getTransaction().commit();
            System.out.println("Done!");


        }finally {
            session.close();
            sessionFactory.close();
        }

    }
}
