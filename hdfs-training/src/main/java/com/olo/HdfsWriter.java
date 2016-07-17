package com.olo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;

/**
 * Created by hduser on 17.07.16.
 */
public class HdfsWriter {
    public static void writeToHdfs(){
        try {
            Configuration configuration = new Configuration(true);

            FileSystem hdfs = FileSystem.get(new URI("hdfs://localhost:54310"), configuration);
            Path filePath = new Path("hdfs://localhost:54310/hdfs-training.data");

            if (hdfs.exists(filePath)){
                hdfs.delete(filePath, true);
            }

            OutputStream hdfsFIle = hdfs.create(filePath, new HdfsWriteProgress());
            BufferedWriter hdfsWriter = new BufferedWriter(new OutputStreamWriter(hdfsFIle, "UTF-8"));
            try {
                for (Integer i = 0; i < 100000; i++) {
                    hdfsWriter.write(String.format("some text to hdfs (%1$s)", i));
                }
            }
            finally {
                hdfsWriter.close();
                hdfs.close();
            }
        }
        catch (Exception exception){
            System.out.print(exception.getMessage());
            exception.printStackTrace();
        }
    }
}
