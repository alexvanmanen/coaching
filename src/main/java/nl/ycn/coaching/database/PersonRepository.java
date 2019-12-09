package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Person findByPersonId(String id) {

        String sql = "SELECT * FROM PERSON WHERE ID = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Person(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("date_of_birth")
                ));

    }

}
