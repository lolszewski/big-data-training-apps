package com.olo;

import org.apache.hadoop.util.Progressable;

/**
 * Created by lukasz on 17.07.16.
 */
public class HdfsWriteProgress implements Progressable {
    public void progress() {
        System.out.println("Writing in progress");
    }
}
