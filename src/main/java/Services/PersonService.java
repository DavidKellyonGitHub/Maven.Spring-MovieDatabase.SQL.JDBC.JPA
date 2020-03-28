package Services;

import Models.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PersonService {
    DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:postgresql:davekelly", "davekelly", "");
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public void addPerson(Person person) {
        jdbcTemplate.execute("INSERT INTO person VALUES ('" + person.getId() + "', '" + person.getFirst_name() + "', '" + person.getLast_name() + "', '" + person.getBirthdate() + "');");
        System.out.println("Inserted Person into table)");
    }

    public void updatePerson(Person person) {
        jdbcTemplate.execute("UPDATE person set (First_name = '" + person.getFirst_name() + "', Last_name = '" + person.getLast_name() + "', birthdate = '" + person.getBirthdate() + "') WHERE id = " + person.getId() + ";");
        System.out.println("Updated Person in table");
    }

    public void deletePerson(Person person) {
        jdbcTemplate.execute("DELETE FROM person WHERE id = " + person.getId() + ";");
        System.out.println("Deleted Person from table");
    }

    public void deletePeople(Person[] people) {
        jdbcTemplate.execute("DELETE FROM person WHERE id IN (" + people[0].getId());
        System.out.println("Deleted People from table");
    }

    public List<Person> findByFirstName(String firstName) {
        return jdbcTemplate.query("SELECT * FROM person WHERE first_Name = '" + firstName + "';", new PersonMapper());
    }

    public List<Person> findByLastName(String lastName) {
        return jdbcTemplate.query("SELECT * FROM person WHERE Last_name = '" + lastName + "';", new PersonMapper());
    }

    public List<Person> findByBirthDate(String birthdate) {
        return jdbcTemplate.query("SELECT * FROM person WHERE birthdate = '" + birthdate + "';", new PersonMapper());
    }

    public Person findById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id = '" + id + "';", new PersonMapper());
    }


    public HashMap<String, List<Person>> getSurnamePersonMap() {
        HashMap<String, List<Person>> surnamesPeople = new HashMap<>();
        ArrayList<String> lastNames = jdbcTemplate.query("SELECT Last_name FROM person ORDER BY Last_name asc;", new PersonMapper()).stream().map(Person::getLast_name).distinct().collect(Collectors.toCollection(ArrayList::new));
        for (String surname : lastNames) {
            surnamesPeople.put(surname, jdbcTemplate.query("SELECT * FROM person WHERE Last_name = '" + surname + "';", new PersonMapper()));
        }
        return surnamesPeople;
    }

    public Map<String, Object> getFirstNamesNumMap() {
        return jdbcTemplate.queryForMap("SELECT first_Name, count(first_name) from person group by first_name");
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM person;", new PersonMapper());
    }


}


