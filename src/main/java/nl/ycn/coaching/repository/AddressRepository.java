package nl.ycn.coaching.repository;

import nl.ycn.coaching.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Optional<Address> findByZipcode(String zipcode);
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
