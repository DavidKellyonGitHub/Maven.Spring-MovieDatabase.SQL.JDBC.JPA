package Services;

import Models.Home;
import Models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeMapper implements RowMapper<Home> {
    @Override
    public Home mapRow(ResultSet rs, int row) throws SQLException {
            Home home = new Home();
            home.setAddress(rs.getString("address"));
            home.setHomeNumber(rs.getString("homeNumber"));
            return home;
    }
}
