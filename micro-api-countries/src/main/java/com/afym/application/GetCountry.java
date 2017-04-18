package com.afym.application;

import com.afym.infraestructure.DataConnector;
import com.afym.infraestructure.DataCountry;
import com.afym.model.Country;
import com.afym.service.GetCountryService;

import java.sql.SQLException;
import java.util.List;

public class GetCountry implements GetCountryService {
    private DataCountry dataCountry;

    public GetCountry() throws SQLException, ClassNotFoundException{
        this.dataCountry = new DataCountry(new DataConnector());
    }

    @Override
    public List<Country> getAll() {
        return this.dataCountry.findAll();
    }

    @Override
    public Country getCities(int countryId) {
        return this.dataCountry.findAllCitiesById(countryId);
    }

    @Override
    public Country getPopulations(int countryId) {
        return this.dataCountry.findAllPopulationById(countryId);
    }
}
