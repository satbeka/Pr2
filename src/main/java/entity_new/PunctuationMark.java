package entity_new;

import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

/**
 * Created by 1 on 09.11.2014.
 */
public class PunctuationMark {

    private static org.slf4j.Logger textLog = LoggerFactory.getLogger("textLog");
    private String mark;


    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public static String getMarkParagraph(){
        String rez=null;
        ResourceBundle resourceBundle=ResourceBundle.getBundle("punctuation_mark");
        rez=resourceBundle.getString("MarkParagraph");
        textLog.debug("Mark paragraph="+rez);
        return rez;
    }

    public static String getMarkSentence(){
        String rez=null;
        ResourceBundle resourceBundle=ResourceBundle.getBundle("punctuation_mark");
        rez=resourceBundle.getString("MarkSentence");
        textLog.debug("Mark sentence="+rez);
        return rez;
    }

    public static String getMarkWord(){
        String rez=null;
        ResourceBundle resourceBundle=ResourceBundle.getBundle("punctuation_mark");
        rez=resourceBundle.getString("MarkWord");
        textLog.debug("Mark word="+rez);
        return rez;
    }


}
