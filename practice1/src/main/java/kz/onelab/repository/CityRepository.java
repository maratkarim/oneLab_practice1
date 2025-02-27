package kz.onelab.repository;

import kz.onelab.dto.Book;
import kz.onelab.dto.City;

import java.util.List;

public interface CityRepository {
    List<City> getAllCity();
    void saveCity(City city);
}
