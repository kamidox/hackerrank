package com.sfox.hackerrank;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class JimAndTheSkycrapersTest {

    private JimAndTheSkycrapers jim;

    @Before
    public void setUp() throws Exception {
        jim = new JimAndTheSkycrapers();
    }

    @Test
    public void testValidPathCount() throws Exception {
        long[] A = {3, 2, 1, 2, 3, 3};
        assertEquals(jim.validPathCount(A), 8);
        long[] B = {1, 1000, 1};
        assertEquals(jim.validPathCount(B), 0);
    }

    @Test
    public void testMain() throws Exception {
        byte[] inbuf = {'6', '\n', '3', ' ', '2', ' ', '1', ' ', '2', ' ', '3', ' ', '3'};
        ByteArrayOutputStream baos = new ByteArrayOutputStream(128);
        System.setIn(new ByteArrayInputStream(inbuf));
        System.setOut(new PrintStream(baos));
        jim.main(null);
        assertEquals(baos.toString().trim(), "8");
    }

    @Test
    public void testValidPathCount_V2() throws Exception {
        long[] A = {3, 2, 1, 2, 3, 3};
        assertEquals(jim.validPathCount_V2(A), 8);
        long[] B = {1, 1000, 1};
        assertEquals(jim.validPathCount_V2(B), 0);
    }
}
