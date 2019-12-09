package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findById(Integer id);

    List<Person> findAll();
}

//@Repository
//public class PersonRepository {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public Person findByPersonId(String id) {
//
//        String sql = "SELECT * FROM PERSON WHERE ID = ?";
//
//        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
//                new Person(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getDate("date_of_birth")
//                ));
//
//    }
//
//    public List<Person> findAllPersons() {
//        String sql = "SELECT * FROM PERSON";
//
//        return jdbcTemplate.query(sql, (rs, rowNum) ->
//                new Person(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getDate("date_of_birth")
//                ));
//    }
//}
