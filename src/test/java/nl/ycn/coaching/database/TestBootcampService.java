package nl.ycn.coaching.database;


import nl.ycn.coaching.model.Bootcamp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestBootcampService {

    @Autowired
    BootcampService bootcampService;

    @Autowired
    BootcampRepository bootcampRepository;

    @Test
    public void contextLoads() {
    }

    public void testAddBootcamp(){
        bootcampService.addBootcamp("DevOps 2019", "IREB, ISQTB");

        Bootcamp bootcamp = bootcampRepository.findByName("DevOps 2019");
        Assert.assertEquals("DevOps2019", bootcamp.getName());
        Assert.assertEquals("IREB, ISQTB", bootcamp.getCourseList());
    }
}
