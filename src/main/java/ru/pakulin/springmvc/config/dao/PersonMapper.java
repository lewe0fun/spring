package ru.pakulin.springmvc.config.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.pakulin.springmvc.config.models.Person;

import javax.swing.tree.TreePath;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name_"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));
        return person;
    }
}
