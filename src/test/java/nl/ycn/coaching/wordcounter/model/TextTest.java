
package nl.ycn.coaching.wordcounter.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TextTest {

    @Test
    public void testGetWordList(){
        Text text = new Text("hallo ik ben alex");
        Assert.assertEquals(4, text.getWordList().size());
    }

}

