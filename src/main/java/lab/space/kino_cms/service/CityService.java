package lab.space.kino_cms.service;

import lab.space.kino_cms.model.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();
    City getCityById(Long cityId);
}
