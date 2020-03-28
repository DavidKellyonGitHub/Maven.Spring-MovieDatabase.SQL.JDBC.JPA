package Services;

import Models.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int row) throws SQLException {
        Person person = new Person();
        person.setFirst_name(rs.getString("First_name"));
        person.setLast_name(rs.getString("Last_name"));
        person.setBirthdate(rs.getString("birthdate"));
        return person;
    }

}
