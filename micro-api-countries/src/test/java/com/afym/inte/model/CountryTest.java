package com.afym.inte.model;

import com.afym.model.City;
import com.afym.model.Country;
import com.afym.model.Population;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class CountryTest extends TestCase{
    public void testIntegration(){
        Country country = new Country("Country");
        country.setFlag("http://domain.com/12/12/country.png");
        country.setCities(this.getCityMock(1));
        country.setPopulations(this.getPopulationMock(1));
        City cityB = country.getCities().get(1);
        assertEquals(cityB.getName(), "City B1");
        assertEquals(cityB.getLongitude(), -15.3555f);
        assertEquals(cityB.getLatitude(), -12.2555f);
        Population populationb = country.getPopulations().get(0);
        assertEquals(populationb.getTag(), "KA");
        assertEquals(populationb.getValue(), "VA1");
        assertEquals(country.getFlag(), "http://domain.com/12/12/country.png");
    }

    private List<City> getCityMock(int mockId){
        List<City> cities = new ArrayList<City>();
        City citya = new City("City A" + mockId);
        citya.setLongitude(12.011f);
        citya.setLatitude(-5.3521f);
        cities.add(citya);
        City cityb = new City("City B" + mockId);
        cityb.setLongitude(-15.3555f);
        cityb.setLatitude(-12.2555f);
        cities.add(cityb);
        City cityc = new City("City C" + mockId);
        cityc.setLongitude(-12.23443f);
        cityc.setLatitude(-1.3255522f);
        cities.add(cityc);
        City cityd = new City("City D" + mockId);
        cityd.setLongitude(-8.35555f);
        cityd.setLatitude(-12.254454f);
        cities.add(cityd);

        return cities;
    }

    private List<Population> getPopulationMock(int mockId) {
        List<Population> populations = new ArrayList<Population>();
        Population populationa = new Population("KA", "VA" + mockId);
        populations.add(populationa);
        Population populationb = new Population("KB", "VB" + mockId);
        populations.add(populationb);
        Population populationc = new Population("KC", "VC" + mockId);
        populations.add(populationc);

        return populations;
    }
}
