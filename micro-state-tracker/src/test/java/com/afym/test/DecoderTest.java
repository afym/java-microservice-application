package com.afym.test;

import com.afym.application.Reader;
import com.afym.application.Writer;
import com.afym.util.Decoder;
import junit.framework.TestCase;
import org.junit.Test;

public class DecoderTest extends TestCase{
    @Test
    public void testDecoder(){
        String base64 = "c29tZSB3b3JkIDAwNw==";
        String decode = Decoder.getString(base64);
        assertEquals("some word 007", decode);
    }

    @Test
    public void testWriterAndReader(){

        String fileB64 = "L2RlY29kZXIudHh0";
        String contentB64 = "a3ViZXJuZXRlcw==";

        Writer writer = new Writer();
        writer.write(Decoder.getString(fileB64), Decoder.getString(contentB64));

        Reader reader = new Reader();
        String content = reader.read(Decoder.getString(fileB64));

        assertEquals("kubernetes", content);
        assertEquals(true, writer.getState());
        assertEquals(true, reader.getState());
    }
}
