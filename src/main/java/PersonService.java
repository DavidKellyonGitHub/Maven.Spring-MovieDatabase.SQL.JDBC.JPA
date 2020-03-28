import io.zipcoder.persistenceapp.Person;
import org.hibernate.sql.HSQLCaseFragment;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Service
public class PersonService {
    private final String url = "jdbc:postgresql:davekelly";
    private final String user = "davekelly";
    private final String password = "";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to SQL server.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void addPerson(Person person) {
        String SQL = "INSERT INTO person VALUES ('" + person.getId() + "', '" + person.getFirst_name() + "', '" + person.getLast_name() + "', '" + person.getBirthdate() + "');";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(SQL);
            System.out.println("Inserted Person into table)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePerson(Person person) {
        String SQL = "UPDATE person set (First_name = '" + person.getFirst_name() + "', Last_name = '" + person.getLast_name() + "', birthdate = '" + person.getBirthdate() + "') WHERE id = " + person.getId() + ";";
        ;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(SQL);
            System.out.println("Updated Person in table)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletePerson(Person person) {
        String SQL = "DELETE FROM person WHERE id = " + person.getId() + ";";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(SQL);
            System.out.println("Deleted Person from table");
        } catch (SQLException e) {
            System.out.println((e.getMessage()));
        }
    }

    public void deletePeople(Person[] people) {
        String SQL = "DELETE FROM person WHERE id IN (" + people[0].getId();
        for (int i = 0; i < people.length; i++) {
            SQL += "," + people[i];
        }
        SQL += ");";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(SQL);
            System.out.println("Deleted People from table");
        } catch (SQLException e) {
            System.out.println((e.getMessage()));
        }
    }

    public String findByFirstName(String firstName) {
        String SQL = "SELECT * FROM person WHERE first_Name = '" + firstName + "';";
        String people = "";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                people += rs.getRow() + "\n";
            }
            System.out.println("Retrieved people from table");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return people;
    }

    public String findByLastName(String lastName) {
        String SQL = "SELECT * FROM person WHERE Last_name = '" + lastName + "';";
        String people = "";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                people += rs.getRow() + "\n";
            }
            System.out.println("Retrieved people from table");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return people;
    }

    public String findByBirthDate(String birthdate) {
        String SQL = "SELECT * FROM person WHERE birthdate = '" + birthdate + "';";
        String people = "";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                people += rs.getRow() + "\n";
            }
            System.out.println("Retrieved people from table");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return people;
    }

    public HashMap<String, String> getSurnamesMap() {
        String SQL = "SELECT Last_name FROM person SORT BY asc";
        HashMap<String, String> surnamesOnly = new HashMap<>();
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                surnamesOnly.put(rs.getString("Last_name"), null);
            }
            System.out.println("Retrieved surnames from table");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return surnamesOnly;
    }

    public HashMap<String, String> getSurnamePersonMap() {
        HashMap<String, String> surnamesPeople = getSurnamesMap();
        for (String surname : surnamesPeople.keySet()) {
            String SQL = "SELECT * FROM person WHERE Last_name = '" + surname + "';";
            try (Connection conn = connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SQL)) {
                while (rs.next()) {
                    String personString = "";
                    for (int i = 1; i <= 4; i++) {
                        personString += surnamesPeople.put(surname, rs.getString(i)) + " ";
                    }
                    surnamesPeople.put(surname, personString);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return surnamesPeople;
    }

    public HashMap<String,String> getFirstNamesNumOfMap() {
            HashMap<String,String> firstNameNumMap = new HashMap<>();
            String SQL = "SELECT first_Name, count(first_name) from person group by first_name";
            try (Connection conn = connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SQL)){
                while (rs.next()){
                    firstNameNumMap.put(rs.getString(1),rs.getString(2));
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
            return firstNameNumMap;
    }
}


