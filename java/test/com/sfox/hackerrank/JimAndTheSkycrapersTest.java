package com.sfox.hackerrank;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class JimAndTheSkycrapersTest {

    @Test
    public void testValidPathCount() throws Exception {
        long[] A = {3, 2, 1, 2, 3, 3};
        assertEquals(JimAndTheSkycrapers.validPathCount(A), 8);
        long[] B = {1, 1000, 1};
        assertEquals(JimAndTheSkycrapers.validPathCount(B), 0);
    }

    @Test
    public void testMain() throws Exception {
        byte[] inbuf = {'6', '\n', '3', ' ', '2', ' ', '1', ' ', '2', ' ', '3', ' ', '3'};
        ByteArrayOutputStream baos = new ByteArrayOutputStream(128);
        System.setIn(new ByteArrayInputStream(inbuf));
        System.setOut(new PrintStream(baos));
        JimAndTheSkycrapers.main(null);
        assertEquals(baos.toString().trim(), "8");
    }

    @Test
    public void testValidPathCount_V2() throws Exception {
        long[] A = {3, 2, 1, 2, 3, 3};
        assertEquals(JimAndTheSkycrapers.validPathCount_V2(A), 8);
        long[] B = {1, 1000, 1};
        assertEquals(JimAndTheSkycrapers.validPathCount_V2(B), 0);
    }
}
