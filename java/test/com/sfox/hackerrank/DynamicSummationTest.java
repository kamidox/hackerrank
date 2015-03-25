package com.sfox.hackerrank;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DynamicSummationTest {

    public void doTest(String in, String out) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(128);
        System.setIn(new ByteArrayInputStream(in.getBytes()));
        System.setOut(new PrintStream(baos));
        DynamicSummation.main(null);
        assertEquals(baos.toString().trim(), out);
    }

    public void doTest(FileInputStream in, FileInputStream out) throws Exception {
        byte[] outbuf = new byte[out.available()];
        assertEquals(out.available(), out.read(outbuf));
        ByteArrayOutputStream baos = new ByteArrayOutputStream(out.available());
        System.setIn(in);
        System.setOut(new PrintStream(baos));
        DynamicSummation.main(null);
        assertEquals(baos.toString().trim(), new String(outbuf));
    }

    @Test
    public void testCase1() throws Exception {
        String in = "4\n1 2\n2 3\n3 4\n4\nU 3 2 2 2\nU 2 3 2 2\nR 1 2 8\nR 4 3 9";
        String out = "2\n3";
        doTest(in, out);
    }

    @Test
    public void testCase2() throws Exception {
        String in = "6\n1 2\n2 3\n3 4\n4 5\n5 6\n2\nU 3 4 2 2\nR 4 5 9";
        String out = "8";
        doTest(in, out);
    }

    @Test
    public void testCase3() throws Exception {
        FileInputStream in = new FileInputStream("test/com/sfox/hackerrank/dynamic_summation_input04.txt");
        FileInputStream out = new FileInputStream("test/com/sfox/hackerrank/dynamic_summation_output04.txt");
        doTest(in, out);
        in.close();
        out.close();
    }
}
