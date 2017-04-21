package com.afym.test;

import com.afym.application.Reader;
import com.afym.application.Writer;
import junit.framework.TestCase;
import org.junit.Test;

public class ReaderTest extends TestCase{
    @Test
    public void testWrite(){
        Writer writer = new Writer();
        writer.write("/test.txt", "abcd");
        Reader reader = new Reader();
        String content = reader.read("/test.txt");

        assertEquals(writer.getState(), true);
        assertEquals(content, "abcd");
        assertEquals(reader.getState(), true);
    }
}