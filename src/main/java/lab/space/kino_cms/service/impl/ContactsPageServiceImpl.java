package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.CinemaInfo;
import lab.space.kino_cms.model.ContactsPage;
import lab.space.kino_cms.repository.ContactsPageRepository;
import lab.space.kino_cms.service.CinemaInfoService;
import lab.space.kino_cms.service.ContactsPageService;
import lab.space.kino_cms.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
@Slf4j
public class ContactsPageServiceImpl implements ContactsPageService {
    private final ContactsPageRepository contactsPageRepository;
    private final CinemaInfoService cinemaInfoService;

    @Override
    public ContactsPage getContactsPage() {
        log.info("---------------Get ContactsPage---------------");
        ContactsPage contactsPage = contactsPageRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new EntityNotFoundException("ContactsPage Not Found"));
        contactsPage.getCinemaInfoList().sort(Comparator.comparingLong(CinemaInfo::getId));
        return contactsPage;
    }

    @Override
    public void updateContactsPage(ContactsPage requestedContactsPage) {
        log.info("---------------Update " + requestedContactsPage + "---------------");
        ContactsPage contactsPage = getContactsPage();
        contactsPage.setSeo(requestedContactsPage.getSeo());
        List<CinemaInfo> requestedCinemaInfos = requestedContactsPage.getCinemaInfoList();
        contactsPage.getCinemaInfoList().clear();
        for (CinemaInfo requestedCinemaInfo : requestedCinemaInfos) {
            if (requestedCinemaInfo.getId() != null) {
                CinemaInfo cinemaInfo = cinemaInfoService.getCinemaInfoById(requestedCinemaInfo.getId());
                cinemaInfo.setCinemaName(requestedCinemaInfo.getCinemaName());
                cinemaInfo.setDisabled(requestedCinemaInfo.isDisabled());
                cinemaInfo.setAddress(requestedCinemaInfo.getAddress());
                cinemaInfo.setCoordinates(requestedCinemaInfo.getCoordinates());
                if (FileUtil.saveFile(requestedCinemaInfo.getFile().getOriginalFilename(), requestedCinemaInfo.getFile())) {
                    FileUtil.deleteFile(cinemaInfo.getLogo());
                    cinemaInfo.setLogo(requestedCinemaInfo.getFile().getOriginalFilename());
                }
                contactsPage.getCinemaInfoList().add(cinemaInfo);
            }else {
                if (FileUtil.saveFile(requestedCinemaInfo.getFile().getOriginalFilename(), requestedCinemaInfo.getFile())) {
                    requestedCinemaInfo.setLogo(requestedCinemaInfo.getFile().getOriginalFilename());
                }
                contactsPage.getCinemaInfoList().add(requestedCinemaInfo);
            }
        }
        contactsPageRepository.save(contactsPage);
        log.info("---------------Success Update " + requestedContactsPage + "---------------");
    }
}
