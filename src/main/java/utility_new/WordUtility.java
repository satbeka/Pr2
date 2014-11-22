package utility_new;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import entity_new.*;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 1 on 18.11.2014.
 */
public class WordUtility {
    private static org.slf4j.Logger wordUtilityLog = LoggerFactory.getLogger("wordUtilityLog");

    public static CompositeComponentTxt getListFromResources(){

        String delimiter= PunctuationMark.getMarkWord();
        Locale locale=Locale.ENGLISH;
        Locale current = Locale.getDefault();
        Locale.setDefault(locale);
        ResourceBundle resourceBundle=ResourceBundle.getBundle("wordList");
        CompositeComponentTxt words = new CompositeComponentTxt();

        if (!resourceBundle.containsKey("List")){wordUtilityLog.error("list of word is empty!");return words;};
        String rez=resourceBundle.getString("List");
        Scanner scan =new Scanner(rez);
        scan.useDelimiter(delimiter);
        while (scan.hasNext()) {
            Word word=new Word();
            word.setName("Word");
            String elementWord = scan.next().toLowerCase();
            wordUtilityLog.debug(" elementWord= "+elementWord);
            word.setElement(elementWord);
            words.add(word);

        }
        Locale.setDefault(current);

        return words;
    }

    public static int setCountWordInSentence(Word inWord,Sentence inSentence){
        String strSentence=inSentence.getElement();
        Pattern p=Pattern.compile(inWord.getElement());
        Matcher m= p.matcher(strSentence);
        int i=0;
        while (m.find()){
            i++;
        }
        inWord.setCountInAllsentences(i);
        wordUtilityLog.debug("Count ="+i+" Word="+inWord.getElement()+" InSentence="+strSentence);
        return i;
    }



}
