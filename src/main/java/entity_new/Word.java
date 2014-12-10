package entity_new;

import utility_new.TextUtility;

import java.util.Comparator;

/**
 * Created by 1 on 22.11.2014.
 */
public class Word extends TextElement {

    public int getCountInAllsentences() {
        return countInAllsentences;
    }

    public void setCountInAllsentences(int countInAllsentences) {
        this.countInAllsentences += countInAllsentences;
    }

    private int countInAllsentences;

    public static Comparator<Word> WordCount = new Comparator<Word>() {

        public int compare(Word o1, Word o2) {

            return Integer.compare(o1.getCountInAllsentences(),o2.getCountInAllsentences());
        }};






}
