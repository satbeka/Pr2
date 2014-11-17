import org.slf4j.LoggerFactory;

/**
 * Created by 1 on 09.11.2014.
 */
public class PunctuationMark {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(Text.class);
    private String mark;


    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public static String getMarkParagraph(){
        String rez,rez1,rez2=null;
        rez1= "(\\n\\s)+";
                //"(\n" +
                //"\s)+";
        //rez2="[/s]";
        //.*[(]|.*[)]|.*[?] 171114
        //.*[(]|.*[)]|.*[(]|.*[?]|.*[\n]|.*[.]
        rez=rez1;//+rez2;
        log.debug("Mark paragraph="+rez);
        return rez;
    }

    public static String getMarkSentence(){
        String rez,rez1=null;
        rez1= "([.|!|?|()])";
        //"(\n" +
        //"\s)+";
        //rez2="[/s]";
        rez=rez1;//+rez2;
        log.debug("Mark sentence="+rez);
        return rez;
    }



}
