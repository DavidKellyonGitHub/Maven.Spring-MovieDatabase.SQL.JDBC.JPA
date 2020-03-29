package Services;

import Models.Person;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface JPAPersonService {

    public void addPerson(Person person);

    public void updatePerson(Person person);

    public void deletePerson(Person person);

    public void deletePeople(Person[] people);

    public List<Person> findByFirstName(String firstName);

    public List<Person> findByLastName(String lastName);

    public List<Person> findByBirthDate(String birthdate);

    public Person findById(Long id);


    public HashMap<String, List<Person>> getSurnamePersonMap();

    public Map<String, Object> getFirstNamesNumMap();

    public List<Person> findAll();

}
