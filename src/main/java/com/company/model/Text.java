package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Text {

    List<Word> list;

    public Text(String text){
        text = removePunctuationMarksEtcetera(text).toLowerCase();
        list = splitup(text); //opsplitsen -> lijst van Strings
    }

    public List<Word> getWordList() {
        return list;
    }

    private String removePunctuationMarksEtcetera(String text) {
        String[] punctuationMarks = {",", ".", ":", "\"","!","'"};
        for(String punctuationMark: punctuationMarks){
            text = text.replace(punctuationMark, "");
        }
        return text.replace("\n", "");
    }

    private List<Word> splitup(String text) {
        return convertToWordList(text.split(" "));
    }

    private List<Word> convertToWordList(String[] stringList) {
        List<Word> list = new ArrayList<>();
        for(String string : stringList){
            list.add(new Word(string));
        }
        return list;
    }
}
