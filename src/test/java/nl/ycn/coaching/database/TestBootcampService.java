package nl.ycn.coaching.database;


import nl.ycn.coaching.model.Bootcamp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBootcampService {

    @Autowired
    BootcampService bootcampService;

    @Autowired
    BootcampRepository bootcampRepository;

    @Mock
    BootcampRepository bootcampRepositoryMock;

    @Test
    public void testAddBootcamp(){
        bootcampService.setBootcampRepository(bootcampRepository);
        bootcampService.addBootcamp("DevOps 2019", "IREB, ISQTB");
        Bootcamp bootcamp = bootcampRepository.findByBootcampName("DevOps 2019");
        Assert.assertEquals("DevOps 2019", bootcamp.getName());
        Assert.assertEquals("IREB, ISQTB", bootcamp.getCourseList());
    }

    @Test
    public void testAddBootcampWithMock(){
        when(bootcampRepositoryMock.findByBootcampName(any())).thenReturn(new Bootcamp("test", "123"));
        bootcampService.setBootcampRepository(bootcampRepositoryMock);
        Bootcamp bootcamp = bootcampRepositoryMock.findByBootcampName("name does not matter");
        Assert.assertEquals("123", bootcamp.getCourseList());
    }

    @Test (expected = NullPointerException.class)
    public void testAddBootcampMockWithException(){
        when(bootcampRepositoryMock.findByBootcampName(any())).thenReturn(new Bootcamp("test", "123"));
        when(bootcampRepositoryMock.save(any())).thenThrow(new NullPointerException());
        bootcampService.setBootcampRepository(bootcampRepositoryMock);
        bootcampService.addBootcamp("DevOps 2019", "IREB, ISQTB");

        //Exception is throw at addBootcamp. Code below is not executed
        Bootcamp bootcamp = bootcampRepository.findByBootcampName("12io3u798739 2019");
        Assert.assertEquals("123", bootcamp.getCourseList());
    }

}
