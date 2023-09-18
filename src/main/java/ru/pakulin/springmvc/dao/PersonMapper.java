package ru.pakulin.springmvc.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.pakulin.springmvc.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("person_id"));
        person.setName(resultSet.getString("person_name"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));
        return person;
    }
}
