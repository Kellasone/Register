package service;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class Log {

    private static Log log;
    Timestamp time;

    public static Log Log() {
        if (log == null) {
            log = new Log();
            return log;
        }
        return log;
    }


    public void addToLog(String filePath, String action, String threadName) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);

        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);


        time = new Timestamp(System.currentTimeMillis());
        printWriter.println(action + "," + time + "," + threadName);

        printWriter.flush();
        printWriter.close();
    }
}
