package utility_new;

import entity_new.CompositeComponentTxt;
import entity_new.PunctuationMark;
import entity_new.Sentence;
import entity_new.TextElement;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

import static utility_new.DataReader.*;

/**
 * Created by 1 on 14.11.2014.
 */
public class TextUtility {
    private static org.slf4j.Logger textUtilLog = LoggerFactory.getLogger("textUtilLog");

    public static CompositeComponentTxt splitSentencesFromFile(String filePath) throws FileNotFoundException {

        FileReader fr = Read(filePath);
        TextElement txt=new TextElement();
        String pSentence="";
        CompositeComponentTxt sentences = new CompositeComponentTxt();

        textUtilLog.debug(" begin ");
        Pattern p=Pattern.compile(PunctuationMark.getMarkSentence());
        textUtilLog.debug("pattern delim="+p.pattern());
        Scanner scan = new Scanner(fr);
        scan.useDelimiter(p);
        int i = 0;

        while (scan.hasNext()) {
            pSentence=scan.next().toLowerCase();
            textUtilLog.debug("                 >------------------entity_new.Sentence--------------------        " );
            textUtilLog.debug("      " + pSentence + "     ");
            Sentence sentence = new Sentence();
            sentence.setName("Sentence");
            sentence.setElement(pSentence);
            textUtilLog.debug("        sentences List i = [" + i + "]");
            textUtilLog.debug("                 -------------------entity_new.Sentence--------------------<        " );
            sentences.add(sentence);
            i++;

        }

        scan.close();
        textUtilLog.debug(filePath + " split sentences end ");
        return sentences;

    }



}
