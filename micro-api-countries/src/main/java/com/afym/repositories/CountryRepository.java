package com.afym.repositories;

import com.afym.model.Country;
import java.util.List;

public interface  CountryRepository {
    List<Country> findAll();
}
