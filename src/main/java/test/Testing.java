package test;

import ru.pakulin.springmvc.config.dao.PersonDAO;
import ru.pakulin.springmvc.config.models.Person;

import java.util.List;

public class Testing {
    public static void main(String[] args) {
        PersonDAO personDAO =new PersonDAO();
        List<Person> people=personDAO.index();
        System.out.println(people);

    }
}
