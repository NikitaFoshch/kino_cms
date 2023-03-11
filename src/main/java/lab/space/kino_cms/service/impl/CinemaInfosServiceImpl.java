package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.CinemaInfo;
import lab.space.kino_cms.repository.CinemaInfoRepository;
import lab.space.kino_cms.service.CinemaInfoService;
import lab.space.kino_cms.service.ContactsPageService;
import lab.space.kino_cms.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CinemaInfosServiceImpl implements CinemaInfoService {
    private final CinemaInfoRepository cinemaInfoRepository;
    private final ContactsPageService contactsPageService;

    @Override
    public List<CinemaInfo> getAllCinemaInfosByOrderByDefaultDesc() {
        log.info("---------------Get All Not Default CinemaInfo---------------");
        return cinemaInfoRepository.getAllCinemaInfosByOrderByDefaultDesc();
    }

    @Override
    public CinemaInfo getCinemaInfoById(Long cinemaInfoId) {
        log.info("---------------Get CinemaInfo By ID " + cinemaInfoId + "---------------");
        return cinemaInfoRepository.findById(cinemaInfoId)
                .orElseThrow(() -> new EntityNotFoundException("CinemaInfo Not Found"));
    }

    @Override
    public void updateCinemaInfoPageById(Long newsId, CinemaInfo requestedCinemaInfo, MultipartFile logo) {
        log.info("---------------Update CinemaInfo By ID " + newsId + "---------------");
        CinemaInfo cinemaInfo = getCinemaInfoById(newsId);

        cinemaInfo.setCinemaName(requestedCinemaInfo.getCinemaName());
        cinemaInfo.setAddress(requestedCinemaInfo.getAddress());
        cinemaInfo.setDisabled(requestedCinemaInfo.isDisabled());
        cinemaInfo.setCoordinates(requestedCinemaInfo.getCoordinates());

        if (FileUtil.saveFile(logo.getOriginalFilename(), logo)) {
            FileUtil.deleteFile(cinemaInfo.getLogo());
            cinemaInfo.setLogo(logo.getOriginalFilename());
        }

        cinemaInfoRepository.save(cinemaInfo);
        log.info("---------------Success Update CinemaInfo By ID " + newsId + "---------------");
    }

    @Override
    public void saveCinemaInfoPage(CinemaInfo cinemaInfo, MultipartFile logo) {
        log.info("---------------Save CinemaInfo---------------");
        if (FileUtil.saveFile(logo.getOriginalFilename(), logo))
            cinemaInfo.setLogo(logo.getOriginalFilename());

        cinemaInfoRepository.save(cinemaInfo);
        log.info("---------------Success Save CinemaInfo---------------");
    }

    @Override
    public void addNewCinemaInfoPage() {
        log.info("---------------Add CinemaInfo---------------");
        CinemaInfo cinemaInfo = new CinemaInfo();
        cinemaInfo.setContactsPage(contactsPageService.getContactsPage());
        cinemaInfoRepository.save(cinemaInfo);
        log.info("---------------Success Add CinemaInfo---------------");
    }

    @Override
    public void deleteCinemaInfoById(Long cinemaInfoId) {
        log.info("---------------Delete CinemaInfo By ID " + cinemaInfoId + "---------------");
        CinemaInfo cinemaInfo = getCinemaInfoById(cinemaInfoId);
        if (!cinemaInfo.isDefault()) {
            if (cinemaInfo.getLogo() != null) {
                FileUtil.deleteFile(cinemaInfo.getLogo());
            }
            cinemaInfoRepository.delete(cinemaInfo);
            log.info("---------------Success Delete CinemaInfo By ID " + cinemaInfoId + "---------------");
        } else log.warn("Failure Attempt Of Deleting Default CinemaInfo");
    }
}
