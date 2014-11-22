package utility_wrong;

import entity_wrong.PunctuationMark;
import entity_wrong.Word;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by 1 on 18.11.2014.
 */
public class WordUtility {
    private static org.slf4j.Logger wordUtilityLog = LoggerFactory.getLogger("wordUtilityLog");

    public static LinkedList<Word> getListfromResources(){

        String delimiter= PunctuationMark.getMarkWord();
        Locale locale=Locale.ENGLISH;
        Locale current = Locale.getDefault();
        Locale.setDefault(locale);
        ResourceBundle resourceBundle=ResourceBundle.getBundle("wordList");
        LinkedList<Word> listWord=new LinkedList<Word>();
        if (!resourceBundle.containsKey("List")){wordUtilityLog.error("list of word is empty!");return listWord;};
        String rez=resourceBundle.getString("List");
        Scanner scan =new Scanner(rez);
        scan.useDelimiter(delimiter);
        while (scan.hasNext()) {
            Word word=new Word();
            String elementWord = scan.next().toLowerCase();
            wordUtilityLog.debug("elementWord="+elementWord);
            word.setElementWord(elementWord);
            listWord.add(word);

        }
        Locale.setDefault(current);

        return listWord;
    }


}
