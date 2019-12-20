
package nl.ycn.coaching;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoachingApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testDoeIets(){
        assert (true);
//
//        Text text = new FileImporter().readFromFile(args[0]);
//        List<Word> wordList = text.getWordList();
//        String s = new WordOccurences(wordList).getTop10();
//        System.out.println(s);
    }

}

