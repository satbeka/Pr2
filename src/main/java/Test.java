import entity.Paragraph;
import entity.Text;
import entity.Word;
import org.slf4j.LoggerFactory;
import utility.TextUtility;
import utility.WordUtility;

import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 * Created by 1 on 09.11.2014.
 */
public class Test {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws FileNotFoundException{



        log.info("begin ");
        int taskId=10;
        LinkedList<Word> wordLinkedList= WordUtility.getListfromResources();
        Text txt= TextUtility.splitSentencesFromFile("C:\\111\\FarFAQ.txt");




        if (taskId!=10) {
            //entity.Text txt=utility.TextUtility.splitParagraphsByScanner("C:\\111\\12place.txt");
            Text txt2 = TextUtility.splitParagraphsByScanner("C:\\111\\FarFAQ.txt");
            //entity.Text txt=utility.TextUtility.splitParagraphsByScanner("C:\\111\\readme.txt");
            Paragraph prg = TextUtility.splitSentencesByMatcher(txt2.getParagraphs().get(3));
        }

        log.info("end ");
        //System.out.println("args222 = [" + args + "]");
    }
}
