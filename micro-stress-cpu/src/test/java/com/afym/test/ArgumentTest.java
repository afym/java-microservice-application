package com.afym.test;

import com.afym.cpu.Arguments;
import junit.framework.TestCase;
import org.junit.Test;

public class ArgumentTest extends TestCase {

    @Test
    public void testProcessSimulator(){
        Arguments arguments = new Arguments();
        arguments.setCpu("4");
        arguments.setTimeout("5");

        assertEquals("4", arguments.getCpu());
        assertEquals("5", arguments.getTimeout());
    }
}