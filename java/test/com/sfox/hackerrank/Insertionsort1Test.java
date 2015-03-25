package com.sfox.hackerrank;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Insertionsort1Test {

    public void doTest(String in, String out) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(128);
        System.setIn(new ByteArrayInputStream(in.getBytes()));
        System.setOut(new PrintStream(baos));
        Insertionsort1.main(null);
        assertEquals(baos.toString().trim(), out);
    }

    @Test
    public void testCase1() throws Exception {
        String in = "5\n2 4 6 8 3";
        String out = "2 4 6 8 8\n2 4 6 6 8\n2 4 4 6 8\n2 3 4 6 8";
        doTest(in, out);
    }

    @Test
    public void testCase2() throws Exception {
        String in = "14\n" +
                "1 3 5 9 13 22 27 35 46 51 55 83 87 23";
        String out = "1 3 5 9 13 22 27 35 46 51 55 83 87 87\n" +
                "1 3 5 9 13 22 27 35 46 51 55 83 83 87\n" +
                "1 3 5 9 13 22 27 35 46 51 55 55 83 87\n" +
                "1 3 5 9 13 22 27 35 46 51 51 55 83 87\n" +
                "1 3 5 9 13 22 27 35 46 46 51 55 83 87\n" +
                "1 3 5 9 13 22 27 35 35 46 51 55 83 87\n" +
                "1 3 5 9 13 22 27 27 35 46 51 55 83 87\n" +
                "1 3 5 9 13 22 23 27 35 46 51 55 83 87";
        doTest(in, out);
    }

    @Test
    public void testCase3() throws Exception {
        String in = "10\n" +
                "2 3 4 5 6 7 8 9 10 1";
        String out = "2 3 4 5 6 7 8 9 10 10\n" +
                "2 3 4 5 6 7 8 9 9 10\n" +
                "2 3 4 5 6 7 8 8 9 10\n" +
                "2 3 4 5 6 7 7 8 9 10\n" +
                "2 3 4 5 6 6 7 8 9 10\n" +
                "2 3 4 5 5 6 7 8 9 10\n" +
                "2 3 4 4 5 6 7 8 9 10\n" +
                "2 3 3 4 5 6 7 8 9 10\n" +
                "2 2 3 4 5 6 7 8 9 10\n" +
                "1 2 3 4 5 6 7 8 9 10";
        doTest(in, out);
    }
}