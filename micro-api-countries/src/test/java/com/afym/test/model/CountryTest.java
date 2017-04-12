package com.afym.test.model;

import com.afym.model.Country;
import junit.framework.TestCase;

public class CountryTest extends TestCase{
    public void testSetGet(){
        Country country = new Country("Peru");
        country.setFlag("http://afym.com/img/12/12/logo.png");
        assertEquals(country.getName(), "Peru");
        assertEquals(country.getFlag(), "http://afym.com/img/12/12/logo.png");
    }
}
