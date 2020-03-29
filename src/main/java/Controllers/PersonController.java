package Controllers;

import Models.Person;
import Services.JPAPersonService;
import Services.PersonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PersonController {

    @Autowired
    JPAPersonService ps;
    public PersonController(JPAPersonService ps){
        this.ps = ps;
    }

    @PostMapping("/people")
    public ResponseEntity<?> createPerson(Person person){
        ps.addPerson(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<?> updatePerson(@RequestBody Person person, @PathVariable String id){
        if (ps.findById(id) != null) {
            ps.updatePerson(person);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/People/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable String id){
        return new ResponseEntity<>(ps.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("people/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable String id){
        ps.deletePerson(ps.findById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/people")
    public ResponseEntity<List<Person>> getAll(){
        return new ResponseEntity<>(ps.findAll(), HttpStatus.OK);
    }

    @GetMapping("/people/surname/{lastName}")
    public ResponseEntity<List<Person>> getByLastName(@PathVariable String lastName){
        return new ResponseEntity<>(ps.findByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping("people/firstname/stats")
    public ResponseEntity<Map<String,Object>> getFirstNameReport(){
        return new ResponseEntity<>(ps.getFirstNamesNumMap(), HttpStatus.OK);
    }



}
