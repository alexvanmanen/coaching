package nl.ycn.coaching.wordcounter.model;

public class Word {

    String word;

    public Word(String word) {
        this.word = word;
    }

    public String toString() {
        return word.toLowerCase();
    }

    public int hashCode() {
        return word.hashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof Word){
            Word otherWord = (Word)obj;
            return (this.word.equalsIgnoreCase(otherWord.word));
        }
        return false;
    }

}
