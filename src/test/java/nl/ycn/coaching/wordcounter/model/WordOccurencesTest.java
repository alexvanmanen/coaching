
package nl.ycn.coaching.wordcounter.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordOccurencesTest {

    @Test
    public void contextLoads() {
        Text text = new Text("hallo ik ik ik ik ben alex");
        WordOccurences wordOccurences = new WordOccurences(text.getWordList());
        System.out.println(wordOccurences.getTop10().contains("ik: 4"));
        wordOccurences.getTop10Map().get("ik");
    }
}

