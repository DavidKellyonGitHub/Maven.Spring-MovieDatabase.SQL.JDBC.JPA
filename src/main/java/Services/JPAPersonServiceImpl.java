package Services;

import Models.Person;
import Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.xml.ws.WebServiceRefs;
import java.util.*;

@Primary
@Service
public class JPAPersonServiceImpl implements JPAPersonService {

    @Autowired
    PersonRepository pr;

    @Override
    public void addPerson(Person person) {
        pr.save(person);
    }

    @Override
    public void updatePerson(Person person) {
        pr.save(person);
    }

    @Override
    public void deletePerson(Person person) {
        pr.delete(person);
    }

    @Override
    public void deletePeople(Person[] people) {
        for(Person person : people){
            pr.delete(person);
        }
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
    public Person findById(Long id) {
        return pr.findOne(id);
    }

    @Override
    public HashMap<String, List<Person>> getSurnamePersonMap() {
        HashMap<String, List<Person>> surnamePerson = new HashMap<>();
        pr.findAll().forEach(person -> surnamePerson.put(person.getLast_name(),Arrays.asList(person)));
        return surnamePerson;
    }

    @Override
    public Map<String, Object> getFirstNamesNumMap() {
//        Map<String,Object> firstNamesNum = new HashMap<>();
//        Integer counter = 1;
//        pr.findAll().forEach(person -> {
//            if (firstNamesNum.containsKey(person.getFirst_name())){
//                counter++;
//                firstNamesNum.put(person.getFirst_name(),counter)
//            } else {
//
//        });
//    }
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }
}
