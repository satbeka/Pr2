package entity;

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
        String rez,rez1=null;
        ResourceBundle resourceBundle=ResourceBundle.getBundle("punctuation_mark");
        rez1=resourceBundle.getString("MarkParagraph");
        //rez1= "(\\n\\s)+";
                //"(\n" +
                //"\s)+";
        //rez2="[/s]";
        //.*[(]|.*[)]|.*[?] 171114
        //.*[(]|.*[)]|.*[(]|.*[?]|.*[\n]|.*[.]
        /*
        * 10 Существует текст и список слов. Для каждого слова из за(данног)о списка
найти, сколько раз оно встречается в каждом предложении, и рассортиро-
вать слова? по убыванию общего количества вхождений.
tyttuutyu!gjgjgj
  GGhhhhh.
        *
        *
        * */
        rez=rez1;//+rez2;
        textLog.debug("Mark paragraph="+rez);
        return rez;
    }

    public static String getMarkSentence(){
        String rez,rez1=null;
        ResourceBundle resourceBundle=ResourceBundle.getBundle("punctuation_mark");
        rez1=resourceBundle.getString("MarkSentence");

        //rez1= "([.|!|?|()])";
        //"(\n" +
        //"\s)+";
        //rez2="[/s]";
        rez=rez1;//+rez2;
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
