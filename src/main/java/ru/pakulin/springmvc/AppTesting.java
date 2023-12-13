package ru.pakulin.springmvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pakulin.springmvc.models.Person;


    public class AppTesting {
        public static void main(String[] args) {
            Configuration configuration = new Configuration().
                    addAnnotatedClass(Person.class);

            try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
                Session session = sessionFactory.getCurrentSession();
                session.beginTransaction();


                Person person1 = new Person("TestPerson1", 33,"11@12.54");
                session.persist(person1);

                Person person2 = new Person("TestPerson2", 66,"12@12.54");
                session.persist(person2);


                session.getTransaction().commit();

            }

        }
    }



