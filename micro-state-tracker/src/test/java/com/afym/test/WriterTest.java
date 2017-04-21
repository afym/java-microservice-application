package com.afym.test;

import com.afym.application.Writer;
import junit.framework.TestCase;
import org.junit.Test;

public class WriterTest extends TestCase{
    @Test
    public void testWrite(){
        Writer writer = new Writer();
        writer.write("/somefile.txt", "some content");
        assertEquals(writer.getState(), true);
    }
}
