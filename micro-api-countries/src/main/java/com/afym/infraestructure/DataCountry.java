package com.afym.infraestructure;

import com.afym.model.City;
import com.afym.model.Population;
import com.afym.repositories.CountryRepository;
import com.afym.model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataCountry implements CountryRepository{
    private DataConnector dataConnector;
    private Connection connection;

    public DataCountry(DataConnector dataConnector) {
        this.dataConnector = dataConnector;
        this.connection = this.dataConnector.getConnection();
    }

    @Override
    public List<Country> findAll() {
        List<Country> countries;

        try {
            Statement statement = this.connection.createStatement();

            String sql = "SELECT id, name, flag FROM countries";
            ResultSet resultSet = statement.executeQuery(sql);
            countries = new ArrayList<Country>();

            while(resultSet.next()) {
                Country country = new Country(resultSet.getString("name"));
                country.setId(resultSet.getInt("id"));
                country.setFlag(resultSet.getString("flag"));
                countries.add(country);
            }

            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
            countries = null;
        }

        return countries;
    }

    @Override
    public Country findAllCitiesById(int id) {
        Country country = this.findById(id);

        if (country != null) {
            List<City> cities;

            try {
                String sql = "SELECT id, name, latitude, longitude FROM cities WHERE country_id = ?";
                PreparedStatement statement = this.connection.prepareStatement(sql);
                statement.setString(1, (new Integer(id)).toString());

                ResultSet resultSet = statement.executeQuery();
                cities = new ArrayList<City>();

                while(resultSet.next()) {
                    City city = new City(resultSet.getString("name"));
                    city.setId(resultSet.getInt("id"));
                    city.setLatitude(resultSet.getFloat("latitude"));
                    city.setLongitude(resultSet.getFloat("longitude"));
                    cities.add(city);
                }

                resultSet.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
                cities = null;
            }

            country.setCities(cities);
        }

        return country;
    }

    @Override
    public Country findAllPopulationById(int id) {
        Country country = this.findById(id);

        if (country != null) {
            List<Population> populations;

            try {
                String sql = "SELECT tag, value FROM population WHERE country_id = ?";
                PreparedStatement statement = this.connection.prepareStatement(sql);
                statement.setString(1, (new Integer(id)).toString());

                ResultSet resultSet = statement.executeQuery();
                populations = new ArrayList<Population>();

                while(resultSet.next()) {
                    Population population = new Population(resultSet.getString("tag"), resultSet.getString("value"));
                    populations.add(population);
                }

                resultSet.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
                populations = null;
            }

            country.setPopulations(populations);
        }

        return country;
    }

    @Override
    public Country findById(int id) {
        Country country = null;

        try {
            String sql = "SELECT id, name, flag FROM countries WHERE id = ?";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1, (new Integer(id)).toString());
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                if (resultSet.getInt("id") == id) {
                    country = new Country(resultSet.getString("name"));
                    country.setId(resultSet.getInt("id"));
                    country.setFlag(resultSet.getString("flag"));
                }
            }

            resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return country;
    }
}
