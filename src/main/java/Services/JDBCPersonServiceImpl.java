package Services;

import Models.Person;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JDBCPersonServiceImpl implements JDBCPersonService {
    @Override
    public void addPerson(Person person) {

    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(Person person) {

    }

    @Override
    public void deletePeople(Person[] people) {

    }

    @Override
    public List<Person> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Person> findByBirthDate(String birthdate) {
        return null;
    }

    @Override
    public Person findById(String id) {
        return null;
    }

    @Override
    public HashMap<String, List<Person>> getSurnamePersonMap() {
        return null;
    }

    @Override
    public Map<String, Object> getFirstNamesNumMap() {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }
}
