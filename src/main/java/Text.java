import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Created by 1 on 09.11.2014.
 */
public class Text {
    private int length;
    //private String txt;
    private String filePath;

    private LinkedList<Paragraph> paragraphs;//=new LinkedList<Paragraph>();
    private LinkedList<Sentence> sentences;//=new LinkedList<Sentence>();
    private LinkedList<Word> words=new LinkedList<Word>();

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
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        //logger
        this.filePath = filePath;
    }

    public Text(String path){

        File f =new File(path);
        if (!f.exists()){
            System.out.println("file is n't exist = [" + path + "]"); return;};
            setFilePath(path);
        this.setLength((int) f.length());
        //f.setReadOnly();


    }

    public void splitParagraphs(Text txt){
      String path=txt.getFilePath();
        LinkedList<Paragraph> prghList=new LinkedList<Paragraph>();
      File f=new File(path);

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
                prghList.add(i,prgh);

            }

            txt.paragraphs=prghList;
            scan.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }





}
