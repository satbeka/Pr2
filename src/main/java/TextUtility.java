import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by 1 on 14.11.2014.
 */
public class TextUtility {
    private static org.slf4j.Logger textUtilLog = LoggerFactory.getLogger("textUtilLog");

    public static Text splitParagraphsByScanner(String inPath) {

        Text txt=new Text(inPath);
        String path = txt.getFilePath();
        LinkedList<Paragraph> prghList = new LinkedList<Paragraph>();
        File f = new File(path);
        //txt.textLog
        textUtilLog.info(path + " split Paragraph begin ");
        textUtilLog.info(" f.toString()= "+f.toString());
        textUtilLog.info(" f.exists();= "+f.exists());
        textUtilLog.info(" f.canRead= "+f.canRead());


        try {
            //textUtilLog.debug("111 scan ");
            //textUtilLog.debug("111 scan delim="+scan.delimiter().toString());

            FileReader fr = new FileReader(f);
            //textUtilLog.info(" fr= "+fr.toString());

            Scanner scan = new Scanner(fr);
            textUtilLog.debug("scan ");
            //scan.match();
            //textUtilLog.debug("scan nextLine="+scan.nextLine());

            textUtilLog.debug("scan nextline="+scan.nextLine());
            Pattern p=Pattern.compile(PunctuationMark.getMarkParagraph());
            scan.useDelimiter(p);
            //scan.useDelimiter("[^a-zA-Z]+");
            textUtilLog.debug("scan delim="+scan.delimiter());
            //String str=p.split(scan.toString());
            //textUtilLog.debug("p.split="+scan.delimiter());
            //scan.next();
            int i = 0;
            textUtilLog.debug("scan next="+scan.hasNext());

            while (scan.hasNext()) {
                textUtilLog.debug("333 scan.toString() = [" + scan.toString() + "]");
                Paragraph prgh = new Paragraph();
                i++;
                prgh.setElementParagraph(scan.toString());
                //log
                textUtilLog.info(" Paragraph = [" + scan.toString() + "]");
                textUtilLog.debug(" scan.toString() = [" + scan.toString() + "]");
                textUtilLog.debug(" prghList i = [" + i + "]");
                prghList.add(i, prgh);

            }

            txt.setParagraphs(prghList);

            scan.close();
            textUtilLog.debug(path + " split Paragraph end ");
            return txt;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    return txt;
    }
}
