/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objectmentor.utilities.args;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luka
 */
public class StringArrayArgumentMarshalerTest extends StringArrayArgumentMarshaler {

    public StringArrayArgumentMarshalerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of set method, of class StringArrayArgumentMarshaler.
     */
    @Test
    public void testSet() throws Exception {
        String[] args = new String[]{"dat1", "dat2", "-l"};
        List<String> argList = Arrays.asList(args);
        ListIterator<String> currentArgument = argList.listIterator();
        StringArrayArgumentMarshaler instance = new StringArrayArgumentMarshaler();
        instance.set(currentArgument);
        assertEquals(new String[]{"dat1", "dat2"}, instance.stringArrayValue);
        assertEquals("-l", currentArgument.next());
    }
}
