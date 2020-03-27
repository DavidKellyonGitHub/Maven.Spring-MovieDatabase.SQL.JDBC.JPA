import io.zipcoder.persistenceapp.Person;
import org.hibernate.sql.HSQLCaseFragment;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

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
        String SQL = "INSERT INTO person VALUES (" + person.getId() + ", " + person.getFirst_name() + ", " + person.getLast_name() + ", " + person.getBirthdate() + ");";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            stmt.executeUpdate(SQL);
            System.out.println("Inserted Person into table)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePerson(Person person, String[] columns, String[] values) {
        String SQL = "UPDATE person set (";
        if (columns.length > 1) {
            SQL += columns[0] + " = '" + values[0];
            for (int i = 1; i < columns.length; i++) {
                SQL += ", " + columns[i];
            }

        } else if (columns.length == 1) {
            SQL += columns[0];
        }
        SQL += ") ";

    }
}
