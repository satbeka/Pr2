package utility_wrong;

import entity_wrong.Paragraph;
import entity_wrong.PunctuationMark;
import entity_wrong.Sentence;
import entity_wrong.Text;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 1 on 14.11.2014.
 */
public class TextUtility {
    private static org.slf4j.Logger textUtilLog = LoggerFactory.getLogger("textUtilLog");



    public static Text splitParagraphsByScanner (String filePath) throws FileNotFoundException{

    /* ???? Exception in thread "main" java.lang.NullPointerException
	at java.io.Reader.<init>(Reader.java:78)
	at java.io.InputStreamReader.<init>(InputStreamReader.java:72)

        utility_wrong.TextUtility.DataReader dataReader=new utility_wrong.TextUtility.DataReader();
        InputStream is=utility_wrong.TextUtility.DataReader.class.getClassLoader().getResourceAsStream(inPath);

        Reader      reader      = new InputStreamReader(is);
        Scanner scan=new Scanner(reader);
*/


        FileReader fr = DataReader.Read(filePath);

        Text txt=new Text(filePath);
        //String path = txt.getFilePath();
        LinkedList<Paragraph> prghList = new LinkedList<Paragraph>();
        //File f = new File(path);
        //txt.textLog
/*
        textUtilLog.info(path + " split entity_wrong.Paragraph begin ");
        textUtilLog.info(" f.toString()= "+f.toString());
        textUtilLog.info(" f.exists();= "+f.exists());
        textUtilLog.info(" f.canRead= "+f.canRead());
*/


            //textUtilLog.debug("111 scan ");
            //textUtilLog.debug("111 scan delim="+scan.delimiter().toString());

        //FileReader fr = new FileReader(f);
            //textUtilLog.info(" fr= "+fr.toString());

        Scanner scan = new Scanner(fr);
            textUtilLog.debug("scan ");
            //scan.match();
            //textUtilLog.debug("scan nextLine="+scan.nextLine());

            //textUtilLog.debug("scan nextline="+scan.nextLine());
            Pattern p=Pattern.compile(PunctuationMark.getMarkParagraph());
            scan.useDelimiter(p);
            //scan.useDelimiter("[^a-zA-Z]+");
            textUtilLog.debug("scan delim="+scan.delimiter());
            //String str=p.split(scan.toString());
            //textUtilLog.debug("p.split="+scan.delimiter());
            //scan.next();
            int i = 0;
            //textUtilLog.debug("scan next="+scan.hasNext());

            while (scan.hasNext()) {

                textUtilLog.debug("      >------------------entity_wrong.Paragraph--------------------        " );
                textUtilLog.debug("" + scan.next() + "");
                Paragraph prgh = new Paragraph();

                prgh.setElementParagraph(scan.next());
                prgh.setElementId(i+1);
                //log
                //textUtilLog.info(" entity_wrong.Paragraph = [" + scan.next() + "]");
                //textUtilLog.debug(" scan.toString() = [" + scan.toString() + "]");
                textUtilLog.debug("        prghList i = [" + i + "]");
                textUtilLog.debug("      -------------------entity_wrong.Paragraph--------------------<        " );
                prghList.add(i, prgh);
                i++;

            }

            txt.setParagraphs(prghList);

            scan.close();
            textUtilLog.debug(filePath + " split entity_wrong.Paragraph end ");
            return txt;


    //return txt;
    }

    public static Paragraph splitSentencesByMatcher(Paragraph inParagraph) {

        String elementParagraph=inParagraph.getElementParagraph();
        String pSentence="";

        LinkedList<Sentence> sentenceList = new LinkedList<Sentence>();

        textUtilLog.debug("splitSentencesByMatcher ");
            //textUtilLog.debug("111 scan delim="+scan.delimiter().toString());

            textUtilLog.debug(" matcher begin ");
            Pattern p=Pattern.compile(PunctuationMark.getMarkSentence());
            textUtilLog.debug("pattern delim="+p.pattern());
            Matcher m=p.matcher(elementParagraph);
            textUtilLog.debug("           elementParagraph=    "+elementParagraph);
            textUtilLog.debug(elementParagraph);

            int i = 0;
        int s;
        int e;
        int sPrevios=0;
            while (m.find()) {
                s=m.start();
                e=m.end();
                textUtilLog.debug("      start= "+s );
                textUtilLog.debug("      end= "+e );
                textUtilLog.debug("                 " );
                if (i==0){ pSentence=elementParagraph.substring(i,s-1);sPrevios=e;}
                else {pSentence=elementParagraph.substring(sPrevios,s);sPrevios=e;};
                //pSentence=m.group();

                textUtilLog.debug("      >------------------2Sentence--------------------        ");
                textUtilLog.debug("               2pSentence=  " + pSentence);
                Sentence sentence = new Sentence();
                sentence.setElementSentence(pSentence);
                sentence.setElementId(i + 1);
                textUtilLog.debug("        sentenceList i = [" + i + "]");
                textUtilLog.debug("      -------------------2Sentence--------------------<        ");
                sentenceList.add(i, sentence);
                i++;


/*
                Pattern p2=Pattern.compile("[^.|?|!|()]");
                Matcher m2=p2.matcher(pSentence);

                textUtilLog.debug("      >------------------entity_wrong.Sentence--------------------        ");
                textUtilLog.debug("               pSentence=  " + pSentence);

                if (m2.matches()) {

                    textUtilLog.debug("      >------------------2Sentence--------------------        ");
                    textUtilLog.debug("               2pSentence=  " + pSentence);
                    entity_wrong.Sentence sentence = new entity_wrong.Sentence();
                    sentence.setElementSentence(pSentence);
                    sentence.setElementId(i + 1);
                    textUtilLog.debug("        sentenceList i = [" + i + "]");
                    textUtilLog.debug("      -------------------2Sentence--------------------<        ");
                    sentenceList.add(i, sentence);
                    i++;
                    //m.group();
                }
*/

            }

            inParagraph.setSentences(sentenceList);

            textUtilLog.debug(" split entity_wrong.Paragraph=[ "+inParagraph.getElementId()+" ] end" );
            return inParagraph;

    }


    public static Text splitSentencesFromFile(String filePath) throws FileNotFoundException {

        FileReader fr = DataReader.Read(filePath);
        Text txt=new Text(filePath);

        String pSentence="";

        LinkedList<Sentence> sentenceList = new LinkedList<Sentence>();

        textUtilLog.debug(" begin ");
        Pattern p=Pattern.compile(PunctuationMark.getMarkSentence());
        textUtilLog.debug("pattern delim="+p.pattern());
        Scanner scan = new Scanner(fr);
        scan.useDelimiter(p);
        int i = 0;

        while (scan.hasNext()) {
            pSentence=scan.next().toLowerCase();
            textUtilLog.debug("                 >------------------entity_wrong.Sentence--------------------        " );
            textUtilLog.debug("      " + pSentence + "     ");
            Sentence sentence = new Sentence();
            sentence.setElementSentence(pSentence);
            sentence.setElementId(i+1);
            textUtilLog.debug("        sentences List i = [" + i + "]");
            textUtilLog.debug("                 -------------------entity_wrong.Sentence--------------------<        " );
            sentenceList.add(i,sentence);
            i++;

        }

        txt.setSentences(sentenceList);

        scan.close();
        textUtilLog.debug(filePath + " split sentences end ");
        return txt;

    }



/*
*
* 10 Существует текст и список слов. Для каждого слова из заданного списка
найти, сколько раз оно встречается в каждом предложении, и рассортиро-
вать слова по убыванию общего количества вхождений.
*
*
* */


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
