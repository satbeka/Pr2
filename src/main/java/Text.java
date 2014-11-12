import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by 1 on 09.11.2014.
 */
public class Text {

    private static org.slf4j.Logger log = LoggerFactory.getLogger("Text");

    private int length;
    //private String txt;
    private String filePath;

    private LinkedList<Paragraph> paragraphs;//=new LinkedList<Paragraph>();
    private LinkedList<Sentence> sentences;//=new LinkedList<Sentence>();
    private LinkedList<Word> words=new LinkedList<Word>();
    public Text(){super();};

    /*public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
*/

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        //logger
        this.length = length;
        log.debug("length="+length);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        //logger
        this.filePath = filePath;
        log.debug("filePath="+filePath);
    }

    public Text(String path){

        File f =new File(path);
        if (!f.exists()){
            log.info("file is n't exist = [" + path + "]");
            //System.out.println("file is n't exist = [" + path + "]");
            return;};
            setFilePath(path);
        this.setLength((int) f.length());
        //f.setReadOnly();


    }

    public void splitParagraphs(Text txt){
      String path=txt.getFilePath();
        LinkedList<Paragraph> prghList=new LinkedList<Paragraph>();
      File f=new File(path);
        log.info(path+" split Paragraph begin ");
        try {
            FileReader fr=new FileReader(f);
            Scanner scan = new Scanner(f);
            scan.useDelimiter(PunctuationMark.getMarkParagraph());
            int i=0;
            while (scan.hasNext()) {
                Paragraph prgh=new Paragraph();
                i++;
                prgh.setElementParagraph(scan.toString());
                //log
                log.info("Paragraph = [" +scan.toString() + "]");
                log.debug("scan.toString() = [" +scan.toString() + "]");
                log.debug("prghList i = [" +i + "]");
                prghList.add(i,prgh);

            }

            txt.paragraphs=prghList;
            scan.close();
            log.info(path+" split Paragraph end ");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }





}
