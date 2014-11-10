import java.io.*;
import java.util.Scanner;

/**
 * Created by 1 on 09.11.2014.
 */
public class Text {
    private int length;
    private String txt;
    private String filePath;

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Text(String path){

        setFilePath(path);
        try {
            BufferedReader br =
                    new BufferedReader(new FileReader
                    (new File(path)));
            String tmp="";
            try {
                while ((tmp = br.readLine()) != null) {
                    this.txt=this.txt.concat(tmp);


                        System.out.println("Line "+tmp);
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                
            }





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }








    }

}
