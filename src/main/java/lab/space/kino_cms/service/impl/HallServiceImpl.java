package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.Cinema;
import lab.space.kino_cms.model.Hall;
import lab.space.kino_cms.repository.HallRepository;
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
public class HallServiceImpl implements HallService {
    private final HallRepository hallRepository;

    @Override
    public Hall getHallById(Long hallId) {
        log.info("---------------Get Hall By ID " + hallId + "---------------");
        return hallRepository.findById(hallId)
                .orElseThrow(() -> new EntityNotFoundException("Hall Not Found"));
    }

    @Override
    public List<Hall> getAllHallByOrderByIdAsc() {
        log.info("---------------Get All Halls---------------");
        return hallRepository.findAll(Sort.by(Sort.Direction.ASC, "createAt"));
    }

    @Override
    public List<Hall> getAllHallByCinemaByOrderByCreatedAtAsc(Cinema cinema) {
        log.info("---------------Get All Halls By Cinema By Order By CreatedAt---------------");
        return hallRepository.getHallsByCinemaOrderByCreateAt(cinema);
    }

    @Override
    public void updateHallById(Long hallId, Hall requstedHall,
                               MultipartFile requestedSchema, MultipartFile requestedTopBanner,
                               MultipartFile requestedGalleryImage1, MultipartFile requestedGalleryImage2,
                               MultipartFile requestedGalleryImage3, MultipartFile requestedGalleryImage4,
                               MultipartFile requestedGalleryImage5) {
        log.info("---------------Update Hall By ID " + hallId + "---------------");
        Hall hall = getHallById(hallId);

        hall.setDisabled(requstedHall.isDisabled());
        hall.setName(requstedHall.getName());
        hall.setDescription(requstedHall.getDescription());

        if (FileUtil.saveFile(requestedSchema.getOriginalFilename(), requestedSchema)) {
            FileUtil.deleteFile(hall.getSchema());
            hall.setSchema(requestedSchema.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedTopBanner.getOriginalFilename(), requestedTopBanner)) {
            FileUtil.deleteFile(hall.getTopBanner());
            hall.setTopBanner(requestedTopBanner.getOriginalFilename());
        }


        if (FileUtil.saveFile(requestedGalleryImage1.getOriginalFilename(), requestedGalleryImage1)) {
            FileUtil.deleteFile(hall.getGalleryImage1());
            hall.setGalleryImage1(requestedGalleryImage1.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage2.getOriginalFilename(), requestedGalleryImage2)) {
            FileUtil.deleteFile(hall.getGalleryImage2());
            hall.setGalleryImage2(requestedGalleryImage2.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage3.getOriginalFilename(), requestedGalleryImage3)) {
            FileUtil.deleteFile(hall.getGalleryImage3());
            hall.setGalleryImage3(requestedGalleryImage3.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage4.getOriginalFilename(), requestedGalleryImage4)) {
            FileUtil.deleteFile(hall.getGalleryImage4());
            hall.setGalleryImage4(requestedGalleryImage4.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage5.getOriginalFilename(), requestedGalleryImage5)) {
            FileUtil.deleteFile(hall.getGalleryImage5());
            hall.setGalleryImage5(requestedGalleryImage5.getOriginalFilename());
        }

        hall.setSeo(requstedHall.getSeo());

        hallRepository.save(hall);
        log.info("---------------Success Update Hall By ID " + hallId + "---------------");
    }

    @Override
    public void updateInitHallById(Long hallId, Hall requstedHall) {
        Hall hall = getHallById(hallId);
        hall.setName(requstedHall.getName());
        hall.setDefault(requstedHall.isDefault());
        hall.setCinema(requstedHall.getCinema());
        hallRepository.save(hall);
    }

    @Override
    public void saveHall(Hall hall, MultipartFile requestedSchema,
                         MultipartFile requestedTopBanner, MultipartFile galleryImage1,
                         MultipartFile galleryImage2, MultipartFile galleryImage3,
                         MultipartFile galleryImage4, MultipartFile galleryImage5) {
        log.info("---------------Save Hall---------------");
        if (FileUtil.saveFile(requestedSchema.getOriginalFilename(), requestedSchema)) {
            hall.setSchema(requestedSchema.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedTopBanner.getOriginalFilename(), requestedTopBanner)) {
            hall.setTopBanner(requestedTopBanner.getOriginalFilename());
        }


        if (FileUtil.saveFile(galleryImage1.getOriginalFilename(), galleryImage1)) {
            hall.setGalleryImage1(galleryImage1.getOriginalFilename());
        }

        if (FileUtil.saveFile(galleryImage2.getOriginalFilename(), galleryImage2)) {
            hall.setGalleryImage2(galleryImage2.getOriginalFilename());
        }

        if (FileUtil.saveFile(galleryImage3.getOriginalFilename(), galleryImage3)) {
            hall.setGalleryImage3(galleryImage3.getOriginalFilename());
        }

        if (FileUtil.saveFile(galleryImage4.getOriginalFilename(), galleryImage4)) {
            hall.setGalleryImage4(galleryImage4.getOriginalFilename());
        }

        if (FileUtil.saveFile(galleryImage5.getOriginalFilename(), galleryImage5)) {
            hall.setGalleryImage5(galleryImage5.getOriginalFilename());
        }

        hallRepository.save(hall);
        log.info("---------------Success Save Hall---------------");
    }

    @Override
    public void deleteHallById(Long hallId) {
        log.info("---------------Delete Hall By ID " + hallId + "---------------");
        Hall hall = getHallById(hallId);
        if (!hall.isDefault()) {
            if (hall.getSchema() != null) {
                FileUtil.deleteFile(hall.getSchema());
            }
            if (hall.getTopBanner() != null) {
                FileUtil.deleteFile(hall.getTopBanner());
            }
            if (hall.getGalleryImage1() != null) {
                FileUtil.deleteFile(hall.getGalleryImage1());
            }
            if (hall.getGalleryImage2() != null) {
                FileUtil.deleteFile(hall.getGalleryImage2());
            }
            if (hall.getGalleryImage3() != null) {
                FileUtil.deleteFile(hall.getGalleryImage3());
            }
            if (hall.getGalleryImage4() != null) {
                FileUtil.deleteFile(hall.getGalleryImage4());
            }
            if (hall.getGalleryImage5() != null) {
                FileUtil.deleteFile(hall.getGalleryImage5());
            }

            hallRepository.deleteById(hallId);
            log.info("---------------Success Delete Hall By ID " + hallId + "---------------");
        } else log.warn("Failure Attempt Of Deleting Default Cinema");


    }

    @Override
    public Hall addHall() {
        Hall hall = new Hall();
        hall.setName("Новый зал");
        return hall;
    }
}
