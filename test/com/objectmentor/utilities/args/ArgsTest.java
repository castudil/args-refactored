/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objectmentor.utilities.args;

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
public class ArgsTest {

    public ArgsTest() {
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
     * Test of has method, of class Args.
     */
    @Test
    public void testHas() {
        try {
            Args arg = new Args("a", new String[]{"-a"});
            assertEquals(true, arg.has('a'));
            assertEquals(false, arg.has('b'));
        } catch (ArgsException e) {
        }
    }

    @Test
    public void testMartinsUsageExample() {
        try {
            Args arg = new Args("l,p#,d*", new String[]{"-lp", "22", "-d", "/tmp"});
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            assertEquals(true, logging);
            assertEquals(22, port);
            assertEquals("/tmp", directory);
        } catch (ArgsException e) {
        }
    }

    @Test
    public void testStringArrayArgument() {
        try {
            Args arg = new Args("p#,f[*],d*", new String[]{"-p", "22", "-f", "dat1", "dat2", "-d", "/tmp"});
            int port = arg.getInt('p');
            String[] files = arg.getStringArray('f');
            String directory = arg.getString('d');
            assertEquals(22, port);
            assertEquals(new String[]{"dat1", "dat2"}, files);
            assertEquals("/tmp", directory);
        } catch (ArgsException e) {
        }
    }

    @Test
    public void testDoubleArg() {
        try {
            Args arg = new Args("-a##", new String[]{"3.402823669E38D"});
            double a = arg.getDouble('a');
            assertEquals(3.402823669E38, a);
        } catch (ArgsException e) {
        }
    }

    @Test
    public void testStringArrayArg() {
        try {
            Args arg = new Args("-a[*]", new String[]{"dat1", "dat2"});
            String[] a = arg.getStringArray('a');
            assertEquals(new String[]{"dat1", "dat2"}, a);
        } catch (ArgsException e) {
        }
    }
}
