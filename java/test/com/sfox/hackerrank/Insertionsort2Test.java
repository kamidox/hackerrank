package com.sfox.hackerrank;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Insertionsort2Test {

    public void doTest(String in, String out) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(128);
        System.setIn(new ByteArrayInputStream(in.getBytes()));
        System.setOut(new PrintStream(baos));
        Insertionsort2.main(null);
        assertEquals(baos.toString().trim(), out);
    }

    @Test
    public void testCase1() throws Exception {
        String in = "6\n" +
                "1 4 3 5 6 2";
        String out = "1 4 3 5 6 2\n" +
                "1 3 4 5 6 2\n" +
                "1 3 4 5 6 2\n" +
                "1 3 4 5 6 2\n" +
                "1 2 3 4 5 6";
        doTest(in, out);
    }

    @Test
    public void testCase2() throws Exception {
        String in = "9\n" +
                "9 8 6 7 3 5 4 1 2";
        String out = "8 9 6 7 3 5 4 1 2\n" +
                "6 8 9 7 3 5 4 1 2\n" +
                "6 7 8 9 3 5 4 1 2\n" +
                "3 6 7 8 9 5 4 1 2\n" +
                "3 5 6 7 8 9 4 1 2\n" +
                "3 4 5 6 7 8 9 1 2\n" +
                "1 3 4 5 6 7 8 9 2\n" +
                "1 2 3 4 5 6 7 8 9";
        doTest(in, out);
    }
}