package com.olo;

import java.io.IOException;
import java.net.URISyntaxException;

public class App 
{
    public static void main( String[] args ) throws URISyntaxException, IOException {
//        HdfsWriter.writeToHdfs();
        HdfsReader.readFromHdfs();
    }
}
