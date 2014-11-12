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
        rez1="\n";
        rez2=" ";
        rez=rez1+rez2;
        log.debug("Mark="+rez);
        return rez;
    }
}
