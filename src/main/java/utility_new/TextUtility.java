package utility_new;

import entity_new.CompositeComponentTxt;
import entity_new.PunctuationMark;
import entity_new.Sentence;
import entity_new.Text;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 1 on 14.11.2014.
 */
public class TextUtility {
    private static org.slf4j.Logger textUtilLog = LoggerFactory.getLogger("textUtilLog");

    public static CompositeComponentTxt splitSentencesFromFile(String filePath) throws FileNotFoundException {

        FileReader fr = DataReader.Read(filePath);
        Text txt=new Text();
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


    /**
     * Created by 1 on 17.11.2014.
     */
    public static class DataReader {
          private static org.slf4j.Logger DataReaderLog = LoggerFactory.getLogger("textLog");

          public static FileReader Read(String file_path) throws FileNotFoundException
          {
              File f = new File(file_path);
              if (!f.exists()) {
                  DataReaderLog.info("file is n't exist = [" + file_path + "]");
                  //System.out.println("file is n't exist = [" + path + "]");
                  return null;
              }


              return new FileReader(f);



          }

    }
}
