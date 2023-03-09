package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.City;
import lab.space.kino_cms.repository.CityRepository;
import lab.space.kino_cms.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        log.info("---------------Get All Cities---------------");
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long cityId) {
        log.info("---------------Get City ID " + cityId + "---------------");
        return cityRepository.findById(cityId)
                .orElseThrow(()-> new EntityNotFoundException("City not found" + cityId));
    }
}
