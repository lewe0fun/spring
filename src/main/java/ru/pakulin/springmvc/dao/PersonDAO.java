package ru.pakulin.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.pakulin.springmvc.models.Person;

import java.util.List;

@Component
public class PersonDAO {
    /*    private final JdbcTemplate jdbcTemplate;
        @Autowired
        public PersonDAO(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }*/
    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        //return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Person", Person.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        //return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new PersonMapper()).stream().findAny().orElse(null);
        Session session = sessionFactory.getCurrentSession();

        return session.get(Person.class, id);
    }
    @Transactional
    public void save(Person person) {
        //jdbcTemplate.update("INSERT INTO Person VALUES(1,?,?,?)", person.getName(), person.getAge(), person.getEmail());
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        //jdbcTemplate.update("UPDATE Person SET name_=?, age=?, email=? WHERE id=?", updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(), id);
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        person.setName(updatedPerson.getName());
        person.setAge(updatedPerson.getAge());
        person.setEmail(updatedPerson.getEmail());
        //session.merge(person);
    }
    @Transactional
    public void delete(int id) {
        //jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Person.class, id));
    }
}
