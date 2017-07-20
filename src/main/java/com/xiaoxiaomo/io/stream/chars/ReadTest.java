package com.xiaoxiaomo.io.stream.chars;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by xiaoxiaomo on 2012/4/11.
 */
public class ReadTest {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file/abc.txt"));
        int read = reader.read(new char[2]);
        int read1 = reader.read(new char[2]);

    }
}
