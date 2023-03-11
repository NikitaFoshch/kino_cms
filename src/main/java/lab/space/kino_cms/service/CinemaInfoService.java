package lab.space.kino_cms.service;

import lab.space.kino_cms.model.CinemaInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CinemaInfoService {
    List<CinemaInfo> getAllCinemaInfosByOrderByDefaultDesc();
    CinemaInfo getCinemaInfoById(Long cinemaInfoId);
    void updateCinemaInfoPageById(Long newsId, CinemaInfo cinemaInfo,
                                MultipartFile logo);
    void saveCinemaInfoPage(CinemaInfo cinemaInfo, MultipartFile logo);
    void addNewCinemaInfoPage();
    void deleteCinemaInfoById(Long cinemaInfoId);
}
