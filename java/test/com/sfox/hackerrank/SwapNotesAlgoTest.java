package com.sfox.hackerrank;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SwapNotesAlgoTest {

    public void doTest(String in, String out) {
        SwapNotesAlgo algo = new SwapNotesAlgo();
        ByteArrayOutputStream baos = new ByteArrayOutputStream(128);
        System.setIn(new ByteArrayInputStream(in.getBytes()));
        System.setOut(new PrintStream(baos));
        algo.main(null);
        assertEquals(baos.toString().trim(), out);
    }

    @Test
    public void testCase1() throws Exception {
        String in = "3\n2 3\n-1 -1\n-1 -1\n2\n1\n1";
        String out = "3 1 2\n2 1 3";
        doTest(in, out);
    }

    @Test
    public void testCase2() throws Exception {
        String in = "5\n2 3\n-1 4\n-1 5\n-1 -1\n-1 -1\n1\n2";
        String out = "4 2 1 5 3";
        doTest(in, out);
    }

    @Test
    public void testCase3() throws Exception {
        String in = "11\n2 3\n4 -1\n5 -1\n6 -1\n7 8\n-1 9\n-1 -1\n10 11\n-1 -1\n-1 -1\n-1 -1\n2\n2\n4";
        String out = "2 9 6 4 1 3 7 5 11 8 10\n2 6 9 4 1 3 7 5 10 8 11";
        doTest(in, out);
    }
}