package com.company;

import com.company.io.FileImporter;
import com.company.model.Text;
import com.company.model.Word;
import com.company.model.WordOccurences;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Text text = new FileImporter().readFromFile(args[0]);
        List<Word> wordList = text.getWordList();
        String s = new WordOccurences(wordList).getTop10();
        System.out.println(s);
    }
}
