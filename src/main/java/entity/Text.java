package entity;

import org.slf4j.LoggerFactory;

import java.util.LinkedList;

/**
 * Created by 1 on 09.11.2014.
 */
public class Text {

    private static org.slf4j.Logger textLog = LoggerFactory.getLogger("textLog");

    private int length;
    //private String txt;
    private String filePath;

    /* if many times need to replace, delete, remove, add */
    private LinkedList<Paragraph> paragraphs;//=new LinkedList<entity.Paragraph>();

    public LinkedList<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(LinkedList<Sentence> sentences) {
        this.sentences = sentences;
    }

    private LinkedList<Sentence> sentences;//=new LinkedList<entity.Paragraph>();
    private LinkedList<Word> words = new LinkedList<Word>();


    /* if many times seek
    private ArrayList<entity.Paragraph> paragraphs;
    private ArrayList<entity.Word> words;// = new ArrayList<entity.Word>();
    */

    public Text() {
        super();
    }

    ;

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
        textLog.debug("length=" + length);
    }

    public LinkedList<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(LinkedList<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        //logger
        this.filePath = filePath;
        textLog.debug("filePath=" + filePath);
    }

    public Text(String filePath) {


        setFilePath(filePath);
        //this.setLength(fileLength);
        //f.setReadOnly();


    }

}



