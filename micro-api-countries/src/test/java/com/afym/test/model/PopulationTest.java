package com.afym.test.model;

import com.afym.model.Population;
import junit.framework.TestCase;

public class PopulationTest extends TestCase{
    public void testSetGet() {
        Population population = new Population("foo", "var");
        assertEquals(population.getTag(), "foo");
        assertEquals(population.getValue(), "var");
        population.setTag("get");
        assertEquals(population.getTag(), "get");
        assertEquals(population.getValue(), "var");
        population.setValue("var");
        assertEquals(population.getTag(), "get");
        assertEquals(population.getValue(), "var");
    }
}
