package com.olo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.*;
import java.net.URI;

/**
 * Created by hduser on 17.07.16.
 */
public class HdfsReader {
    public static void readFromHdfs(){
        try {
            Configuration configuration = new Configuration(true);

            FileSystem hdfs = FileSystem.get(new URI("hdfs://localhost:54310"), configuration);
            Path filePath = new Path("hdfs://localhost:54310/hdfs-training.data");
            InputStream hdfsFIle = hdfs.open(filePath);
            BufferedReader hdfsReader = new BufferedReader(new InputStreamReader(hdfsFIle, "UTF-8"));

            try {

                char[] currentChars = new char[101];
                Integer charactersRed = 0;
                Integer charsCountPerRead = 100;

                while (charactersRed != -1){
                    charactersRed = hdfsReader.read(currentChars, 0, charsCountPerRead);
                    System.out.println(currentChars);
                }
            }
            finally {
                hdfsReader.close();
                hdfs.close();
            }
        }
        catch (Exception exception){
            System.out.print(exception.getMessage());
            exception.printStackTrace();
        }
    }
}
