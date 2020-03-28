package Services;

import Models.Home;
import Models.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:postgresql:davekelly", "davekelly", "");
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public void addHome(Home home){
        jdbcTemplate.execute("INSERT INTO home VALUES ('" + home.getId() + "', '" + home.getAddress() + "', '" + home.getHomeNumber() + "');");
    }

    public void addPersonToHome(Person person, Home home){
        jdbcTemplate.execute("UPDATE person SET (homeNumber = " + home.getId() + ") WHERE id = " + person.getId() + ";");
    }

    public void updateHome(Home home){
        jdbcTemplate.execute("UPDATE home SET (address = '" + home.getAddress() + "', homeNumber = '" + home.getHomeNumber() + "');");
    }

    public void deleteHome(Home home){
        jdbcTemplate.execute("DELETE FROM home WHERE id = '" + home.getId() + "';");
    }

    public void deleteListOfHomes(List<Home> homeList) {
        String idList = homeList.get(0).getId().toString();
        for (int i = 1;i< homeList.size();i++){
            idList += ", " + homeList.get(i).getId().toString();
        }
        jdbcTemplate.execute("DELETE FROM home WHERE id IN (" + idList + ");");
    }

    public List<Home> findById(String id){
        return jdbcTemplate.query("SELECT * FROM home WHERE id = '" + id + "';", new HomeMapper());
    }

    public List<Home> findByAddress(String address){
        return jdbcTemplate.query("SELECT * FROM home WHERE address = '" + address + "';", new HomeMapper());
    }

    public List<Home> findByHomeNumber(String homeNumber){
        return jdbcTemplate.query("SELECT * FROM home WHERE homeNumber = '" + homeNumber + "';", new HomeMapper());
    }

    public List<Home> findByPersonID(String personID){
        return jdbcTemplate.query("SELECT * FROM personID WHERE personID = '" + personID + "';", new HomeMapper());
    }

    public List<Person> findPeople(Home home){
        return jdbcTemplate.query("SELECT * FROM person WHERE home_id = " + home.getId() + ";", new PersonMapper());
    }




}
