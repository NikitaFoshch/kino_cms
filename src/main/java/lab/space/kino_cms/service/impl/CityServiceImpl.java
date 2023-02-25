package lab.space.kino_cms.service.impl;

import lab.space.kino_cms.model.City;
import lab.space.kino_cms.repository.CityRepository;
import lab.space.kino_cms.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long cityId) {
        Optional<City> optionalCity = cityRepository.findById(cityId);
        return optionalCity.get();
    }
}
