package com.afym.test;

import com.afym.cpu.Arguments;
import com.afym.cpu.StressCommand;
import junit.framework.TestCase;
import org.junit.Test;

public class StressCommandTest extends TestCase {
    @Test
    public void testStressCommand() {
        Arguments arguments = new Arguments();
        arguments.setCpu("4");
        arguments.setTimeout("30");

        String command = StressCommand.build(arguments);
        assertEquals("stress --cpu 4 --timeout 30 ", command);
    }
}
