package lab.space.kino_cms.service.impl;

import lab.space.kino_cms.model.CommonPage;
import lab.space.kino_cms.model.ContactsPage;
import lab.space.kino_cms.model.MainPage;
import lab.space.kino_cms.service.CommonPageService;
import lab.space.kino_cms.service.ContactsPageService;
import lab.space.kino_cms.service.MainPageService;
import lab.space.kino_cms.service.NavbarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NavbarServiceImpl implements NavbarService {
    private final MainPageService mainPageService;
    private final CommonPageService commonPageService;
    private final ContactsPageService contactsPageService;
    @Override
    public void addNavbarModel(Model model) {
        MainPage mainPage = mainPageService.getMainePage();
        List<CommonPage> defaultCommonPages = commonPageService.getAllCommonPageByDefaultTrueByOrderByIdAsc();
        ContactsPage contactsPage = contactsPageService.getContactsPage();
        List<CommonPage> commonPages = commonPageService.getAllCommonPageByDefaultFalseByOrderByIdAsc();
        model.addAttribute("mainPage", mainPage);
        model.addAttribute("defaultCommonPages", defaultCommonPages);
        model.addAttribute("contactsPage", contactsPage);
        model.addAttribute("commonPages", commonPages);
    }
}
