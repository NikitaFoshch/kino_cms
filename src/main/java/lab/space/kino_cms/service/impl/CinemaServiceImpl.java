package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.Cinema;
import lab.space.kino_cms.repository.CinemaRepository;
import lab.space.kino_cms.service.CinemaService;
import lab.space.kino_cms.service.HallService;
import lab.space.kino_cms.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;
    private final HallService hallService;
    @Override
    public List<Cinema> getAllCinema() {
        log.info("---------------Get All Cinema Order By CreateAt ASC---------------");
        return cinemaRepository.findAll(Sort.by(Sort.Direction.ASC, "createAt"));
    }

    @Override
    public Cinema getCinemaById(Long cinemaId) {
        log.info("---------------Get Cinema By ID " + cinemaId + "---------------");
        return cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new EntityNotFoundException("Cinema Not found By ID " + cinemaId));
    }

    @Override
    public void updateCinemaById(Long cinemaId, Cinema requstedCinema,
                                 MultipartFile requestedLogo, MultipartFile requestedTopBanner,
                                 MultipartFile requestedGalleryImage1, MultipartFile requestedGalleryImage2,
                                 MultipartFile requestedGalleryImage3, MultipartFile requestedGalleryImage4,
                                 MultipartFile requestedGalleryImage5) {

        log.info("---------------Update Cinema By ID " + cinemaId + "---------------");
        Cinema cinema = getCinemaById(cinemaId);

        cinema.setDisabled(requstedCinema.isDisabled());
        cinema.setName(requstedCinema.getName());
        cinema.setDescription(requstedCinema.getDescription());
        cinema.setConditions(requstedCinema.getConditions());

        if (FileUtil.saveFile(requestedLogo.getOriginalFilename(), requestedLogo)) {
            FileUtil.deleteFile(cinema.getLogo());
            cinema.setLogo(requestedLogo.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedTopBanner.getOriginalFilename(), requestedTopBanner)) {
            FileUtil.deleteFile(cinema.getTopBanner());
            cinema.setTopBanner(requestedTopBanner.getOriginalFilename());
        }


        if (FileUtil.saveFile(requestedGalleryImage1.getOriginalFilename(), requestedGalleryImage1)) {
            FileUtil.deleteFile(cinema.getGalleryImage1());
            cinema.setGalleryImage1(requestedGalleryImage1.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage2.getOriginalFilename(), requestedGalleryImage2)) {
            FileUtil.deleteFile(cinema.getGalleryImage2());
            cinema.setGalleryImage2(requestedGalleryImage2.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage3.getOriginalFilename(), requestedGalleryImage3)) {
            FileUtil.deleteFile(cinema.getGalleryImage3());
            cinema.setGalleryImage3(requestedGalleryImage3.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage4.getOriginalFilename(), requestedGalleryImage4)) {
            FileUtil.deleteFile(cinema.getGalleryImage4());
            cinema.setGalleryImage4(requestedGalleryImage4.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage5.getOriginalFilename(), requestedGalleryImage5)) {
            FileUtil.deleteFile(cinema.getGalleryImage5());
            cinema.setGalleryImage5(requestedGalleryImage5.getOriginalFilename());
        }

        cinema.setSeo(requstedCinema.getSeo());

        cinemaRepository.save(cinema);
        log.info("---------------Success Update Cinema By ID " + cinemaId + "---------------");
    }

    @Override
    public void saveCinema(Cinema cinema, MultipartFile requestedLogo,
                           MultipartFile requestedTopBanner, MultipartFile galleryImage1,
                           MultipartFile galleryImage2, MultipartFile galleryImage3,
                           MultipartFile galleryImage4, MultipartFile galleryImage5) {
        log.info("---------------Save Cinema---------------");
        if (FileUtil.saveFile(requestedLogo.getOriginalFilename(), requestedLogo)) {
            cinema.setLogo(requestedLogo.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedTopBanner.getOriginalFilename(), requestedTopBanner)) {
            cinema.setTopBanner(requestedTopBanner.getOriginalFilename());
        }


        if (FileUtil.saveFile(galleryImage1.getOriginalFilename(), galleryImage1)) {
            cinema.setGalleryImage1(galleryImage1.getOriginalFilename());
        }

        if (FileUtil.saveFile(galleryImage2.getOriginalFilename(), galleryImage2)) {
            cinema.setGalleryImage2(galleryImage2.getOriginalFilename());
        }

        if (FileUtil.saveFile(galleryImage3.getOriginalFilename(), galleryImage3)) {
            cinema.setGalleryImage3(galleryImage3.getOriginalFilename());
        }

        if (FileUtil.saveFile(galleryImage4.getOriginalFilename(), galleryImage4)) {
            cinema.setGalleryImage4(galleryImage4.getOriginalFilename());
        }

        if (FileUtil.saveFile(galleryImage5.getOriginalFilename(), galleryImage5)) {
            cinema.setGalleryImage5(galleryImage5.getOriginalFilename());
        }

        cinemaRepository.save(cinema);
        cinema.getHalls().get(0).setName("1 Зал");
        cinema.getHalls().get(0).setDefault(true);
        cinema.getHalls().get(0).setCinema(cinema);
        hallService.updateInitHallById(cinema.getHalls().get(0).getId(),cinema.getHalls().get(0));

        log.info("---------------Success Save Cinema---------------");
    }


    @Override
    public void deleteCinemaById(Long cinemaId) {
        log.info("---------------Delete Cinema By ID " + cinemaId + "---------------");
        Cinema cinema = getCinemaById(cinemaId);
        if (!cinema.isDefault()) {
            if (cinema.getLogo() != null) {
                FileUtil.deleteFile(cinema.getLogo());
            }
            if (cinema.getTopBanner() != null) {
                FileUtil.deleteFile(cinema.getTopBanner());
            }
            if (cinema.getGalleryImage1() != null) {
                FileUtil.deleteFile(cinema.getGalleryImage1());
            }
            if (cinema.getGalleryImage2() != null) {
                FileUtil.deleteFile(cinema.getGalleryImage2());
            }
            if (cinema.getGalleryImage3() != null) {
                FileUtil.deleteFile(cinema.getGalleryImage3());
            }
            if (cinema.getGalleryImage4() != null) {
                FileUtil.deleteFile(cinema.getGalleryImage4());
            }
            if (cinema.getGalleryImage5() != null) {
                FileUtil.deleteFile(cinema.getGalleryImage5());
            }

            cinemaRepository.deleteById(cinemaId);
            log.info("---------------Success Delete Cinema By ID " + cinemaId + "---------------");
        } else log.warn("Failure Attempt Of Deleting Default Cinema");
    }

    @Override
    public Cinema addCinema() {
        Cinema cinema = new Cinema();
        cinema.setName("Новый Кинотеатр");
        return cinema;
    }


}
