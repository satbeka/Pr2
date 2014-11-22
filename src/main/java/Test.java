import entity_new.ComponentTxt;
import entity_new.CompositeComponentTxt;
import entity_new.Sentence;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 1 on 09.11.2014.
 */


/*
*
* 10 Существует текст и список слов. Для каждого слова из заданного списка
найти, сколько раз оно встречается в каждом предложении, и рассортиро-
вать слова по убыванию общего количества вхождений.
*
*
* */

public class Test {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws FileNotFoundException{



        log.info("begin ");
        int taskId=10;
        CompositeComponentTxt words= utility_new.WordUtility.getListFromResources();
        CompositeComponentTxt sentences=utility_new.TextUtility.splitSentencesFromFile("C:\\111\\FarFAQ2.txt");
        ArrayList<ComponentTxt> listComponentTxt=words.getListComponentTxt();
        ArrayList<entity_new.Word> wordsToSort=new ArrayList<entity_new.Word>();
        //String strWord;
        int i;
        for (ComponentTxt componentWord:listComponentTxt) {
            entity_new.Word word=(entity_new.Word)componentWord;
            word.setCountInAllsentences(0);
            //strWord=word.getElement();
            for (ComponentTxt componentSentence : sentences.getListComponentTxt()) {
                Sentence sentence = (Sentence) componentSentence;
                i=utility_new.WordUtility.setCountWordInSentence(word,sentence);
            }

            wordsToSort.add(word);
        }

        //entity_new.Word simpleWord=new entity_new.Word();
        Collections.sort(wordsToSort, entity_new.Word.WordCount);
        for (entity_new.Word word:wordsToSort){
            log.info("  word="+word.getElement()+" cnt="+word.getCountInAllsentences());
        }

        log.info("end ");
        //System.out.println("args222 = [" + args + "]");
    }
}
