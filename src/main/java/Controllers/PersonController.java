package Controllers;

import Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {

    @Autowired
    PersonService ps;
    public PersonController(PersonService ps){
        this.ps = ps;
    }
}
