import entity_new.ComponentTxt;
import entity_new.CompositeComponentTxt;
import entity_new.Sentence;
import org.slf4j.LoggerFactory;
import utility_new.DataReader;
import utility_new.TextUtility;
import utility_new.WordUtility;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 1 on 09.11.2014.
 */


public class Test {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws FileNotFoundException{



        log.info("begin ");
        int taskId=10;
        CompositeComponentTxt words= WordUtility.getListFromResources();
        CompositeComponentTxt sentences= TextUtility.splitSentencesFromFile(DataReader.getFilePath());
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
                i=WordUtility.setCountWordInSentence(word,sentence);
            }

            wordsToSort.add(word);
        }

        //entity_new.Word simpleWord=new entity_new.Word();
        Collections.sort(wordsToSort, entity_new.Word.WordCount);
        log.info("  sort by Task10 are: ");
        for (entity_new.Word word:wordsToSort){
            log.info("  word="+word.getElement()+" count="+word.getCountInAllsentences());
        }

        log.info("end ");
        //System.out.println("args222 = [" + args + "]");
    }
}
