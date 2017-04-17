package com.afym.infraestructure;

import com.afym.repositories.CountryRepository;
import com.afym.model.Country;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataCountry implements CountryRepository{
    private DataConnector dataConnector;

    public DataCountry(DataConnector dataConnector) {
        this.dataConnector = dataConnector;
    }

    @Override
    public List<Country> findAll() {
        List<Country> countries;

        try {
            Connection connection = dataConnector.getConnection();
            Statement statement = connection.createStatement();

            String sql = "SELECT id, name, flag FROM countries";
            ResultSet resultSet = statement.executeQuery(sql);
            countries = new ArrayList<Country>();

            while(resultSet.next()) {
                Country country = new Country(resultSet.getString("name"));
                country.setFlag((new Integer(resultSet.getInt("id"))).toString());
                country.setFlag(resultSet.getString("flag"));
                countries.add(country);
            }

            resultSet.close();
        } catch (SQLException exception) {
            countries = null;
        }

        return countries;
    }
}
