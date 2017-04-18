package com.afym.service;

import com.afym.model.Country;

import java.util.List;

public interface GetCountryService {
    List<Country> getAll();
    Country getCities(int countryId);
    Country getPopulations(int countryId);
}
