package nl.ycn.coaching.controller;

import com.company.model.Text;
import com.company.model.Word;
import com.company.model.WordOccurences;
import nl.ycn.coaching.database.PersonRepository;
import nl.ycn.coaching.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private PersonRepository personRepository;

    private static int counter = 1;

    @GetMapping("hallo")
    public String getText(){
        counter = counter +100;
        return "hallo hallo " +  counter;
    }

    @PostMapping("top10")
    public String top10(@RequestBody String input) {
        Text text = new Text(input);
        List<Word> wordList = text.getWordList();
        String s = new WordOccurences(wordList).getTop10();
        return "the number of occurences: " + s;
    }
    //http://www.google.nl - GET-request via het http-protocol naar het webadres www.google.nl
    //GET POST, PUT, DELETE
    //ftp://vanmanen.nl - ftp (FILE TRANSFER PROTOCOL

    @GetMapping("top10aa")
    public String getFoos(@RequestParam String text) {
        return "De tekst is: " + text;
    }

    @GetMapping("/person/{id}")
    public Person welkom(@PathVariable String id){
        Person person = personRepository.findByPersonId(id);
        return person;
    }
}
