package com.afym.test.model;

import com.afym.model.City;
import junit.framework.TestCase;

public class CityTest extends TestCase {

    public void testSetGet(){
        City city = new City("Lima");
        city.setLatitude(12.0f);
        city.setLongitude(13.1f);
        assertEquals(city.getName(), "Lima");
        assertEquals(city.getLatitude(), 12.0f);
        assertEquals(city.getLongitude(), 13.1f);
        city.setName("La Paz");
        assertEquals(city.getName(), "La Paz");
        city.setLatitude(-10.23232323f);
        city.setLongitude(12.9999292f);
        assertEquals(city.getLatitude(), -10.23232323f);
        assertEquals(city.getLongitude(), 12.9999292f);
    }
}