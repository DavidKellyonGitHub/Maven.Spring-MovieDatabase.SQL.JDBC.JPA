package Services;

import Models.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface JDBCPersonService {

    public void addPerson(Person person);

    public void updatePerson(Person person);

    public void deletePerson(Person person);

    public void deletePeople(Person[] people);

    public List<Person> findByFirstName(String firstName);

    public List<Person> findByLastName(String lastName);

    public List<Person> findByBirthDate(String birthdate);

    public Person findById(String id);


    public HashMap<String, List<Person>> getSurnamePersonMap();

    public Map<String, Object> getFirstNamesNumMap();

    public List<Person> findAll();

}
