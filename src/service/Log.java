package service;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class Log {

    Timestamp time;
    private static Log log;
    public static Log Log() {
        if(log == null) {
            log = new Log();
            return log;
        }
        return log;
    }


    public void addToLog(String filePath,String action) throws IOException
    {
        FileWriter fw = new FileWriter(filePath,true);

        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);


        time=new Timestamp(System.currentTimeMillis());
        printWriter.println(action+","+time);

        printWriter.flush();
        printWriter.close();
    }
}
