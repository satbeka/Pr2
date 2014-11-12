import org.slf4j.LoggerFactory;

/**
 * Created by 1 on 09.11.2014.
 */
public class Test {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {



        log.info("begin ");
        Text txt=new Text("C:\\111\\12place.txt");
        txt.splitParagraphs(txt);



        log.info("end ");
        //System.out.println("args222 = [" + args + "]");
    }
}
