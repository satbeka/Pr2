package utility_new;

import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by 1 on 17.11.2014.
 */
public class DataReader {
    private static org.slf4j.Logger DataReaderLog = LoggerFactory.getLogger("textLog");

    public static String getFilePath(){
        String rez;
        //Locale locale=Locale.ENGLISH;
        //Locale current = Locale.getDefault();
        //Locale.setDefault(locale);
        ResourceBundle resourceBundle=ResourceBundle.getBundle("filePath");
        rez=resourceBundle.getString("File_Path");
        DataReaderLog.debug("file Path="+rez);
        //Locale.setDefault(current);
        return rez;
    }


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
