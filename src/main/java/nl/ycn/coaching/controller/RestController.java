package nl.ycn.coaching.controller;

import com.company.model.Text;
import com.company.model.Word;
import com.company.model.WordOccurences;
import nl.ycn.coaching.model.*;
import nl.ycn.coaching.repository.AddressRepository;
import nl.ycn.coaching.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

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

    @PostMapping("/createPerson")
    public Person createPerson(@RequestParam Person person){
        Person person2 = new Person(100, "test", new Date());
        return personRepository.save(person2);
    }

    @GetMapping("/person/{id}")
    public Optional<Person> getPerson(@PathVariable Integer id){
        return personRepository.findById(id);
    }

    @GetMapping("/personByName/{name}")
    public Optional<Person> getPerson(@PathVariable String name){
        return personRepository.findByName(name);
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @GetMapping("/address/{zipCode}")
    public Optional<Address> getAddress(@PathVariable String zipCode){
        return addressRepository.findByZipcode(zipCode);
    }
}
