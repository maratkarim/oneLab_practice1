package kz.onelab.repository.impl;

import kz.onelab.dto.City;
import kz.onelab.dto.Library;
import kz.onelab.repository.CityRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CityRepositoryImpl implements CityRepository {
    private final List<City> cities = new ArrayList<>();

    @Override
    public List<City> getAllCity() {
        return cities;
    }

    @Override
    public void saveCity(City city) {
        cities.add(city);
    }
}
