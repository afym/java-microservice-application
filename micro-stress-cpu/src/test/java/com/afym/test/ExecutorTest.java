package com.afym.test;

import com.afym.cpu.Arguments;
import com.afym.cpu.Executor;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

public class ExecutorTest extends TestCase {
    @Test
    public void testStressCommand() throws IOException, InterruptedException {
        Arguments arguments = new Arguments();
        arguments.setCpu("4");
        arguments.setTimeout("5");

        Executor executor = new Executor(arguments);
        String response = executor.run();

        assertEquals(true, response.contains("successful"));
    }
}
