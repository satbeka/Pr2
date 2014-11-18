import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by 1 on 17.11.2014.
 */
public class DataReader {
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
