package kz.onelab.repository.impl;

import kz.onelab.dto.City;
import kz.onelab.dto.Library;
import kz.onelab.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CityRepositoryImpl implements CityRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CityRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<City> getAllCity() {
        return jdbcTemplate.query("SELECT * FROM cities",
                (rs, rowNum) -> new City(rs.getLong("id"), rs.getString("name"), new ArrayList<>()));
    }

    @Override
    public void saveCity(City city) {
        jdbcTemplate.update("INSERT INTO cities (name) VALUES (?)", city.getName());
        for (Library library : city.getLibraries()) {
            jdbcTemplate.update("INSERT INTO city_libraries (city_id, library_id) VALUES (?, ?)",
                    city.getId(), library.getId());
        }
    }

}