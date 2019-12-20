
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
    public void testGetTop10Map() {
        //Arrange
        Text text = new Text("hallo ik ik ik ik ben alex");
        //Act
        WordOccurences wordOccurences = new WordOccurences(text.getWordList());

        //Assert
        Assert.assertEquals(1, getNumberOfOccurrences(wordOccurences,"hallo"));
        Assert.assertEquals(4, getNumberOfOccurrences(wordOccurences,"ik"));
        Assert.assertEquals(1, getNumberOfOccurrences(wordOccurences,"ben"));
        Assert.assertEquals(1, getNumberOfOccurrences(wordOccurences,"alex"));
    }

    @Test
    public void testGetTop10MapWithCapitals() {
        //Arrange
        Text text = new Text("Ik ik Ik ");
        //Act
        WordOccurences wordOccurences = new WordOccurences(text.getWordList());
        //Assert
        Assert.assertEquals(3, getNumberOfOccurrences(wordOccurences,"ik"));
    }

    public int getNumberOfOccurrences(WordOccurences wordOccurences, String word){
        return  wordOccurences.getTop10Map().get(new Word(word));
    }

}

