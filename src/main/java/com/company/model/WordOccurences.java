package com.company.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordOccurences {

    private Map<Word, Integer> wordOccurrencesMap;
    private Map<Word, Integer> top10Words;

    public WordOccurences(List<Word> wordList){
        wordOccurrencesMap = getOccurrences(wordList);
    }

    public String getTop10(){
        filter();
        createTop10();
        return getTop10Occurences();
    }

    private Map<Word, Integer> getOccurrences(List<Word> list) {
        Map<Word, Integer> words = new HashMap<>();
        for (Word word : list) {
            Integer integer = words.get(word);
            if (integer == null) {
                words.put(word, 1);
            } else {
                integer = integer + 1;
                words.put(word, integer);
            }
        }
        return words;
    }

    private void filter() {
        wordOccurrencesMap.remove(new Word("een"));
        wordOccurrencesMap.remove(new Word("de"));
        wordOccurrencesMap.remove(new Word("het"));
    }

    private Map<Word, Integer> createTop10() {
       top10Words = new LinkedHashMap<>();

        for (int i = 0; i < 10; i++) {
            int maxCount = 0;
            Word wordWithMostOccurences = new Word("");
            for(Word word : wordOccurrencesMap.keySet()){
                int count = wordOccurrencesMap.get(word);
                if(count > maxCount && top10Words.get(word) == null) {
                    wordWithMostOccurences = word;
                    maxCount = count;
                }
            }
            top10Words.put(wordWithMostOccurences, maxCount);
        }
        return top10Words;
    }

    private String getTop10Occurences() {
        String s = "";
        for (Word key : top10Words.keySet()) {
            s = s + key +": "+ top10Words.get(key) + "\n";
        }
        return s;
    }

}
