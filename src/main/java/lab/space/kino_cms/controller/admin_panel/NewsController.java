package lab.space.kino_cms.controller.admin_panel;

import lab.space.kino_cms.model.News;
import lab.space.kino_cms.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("admin/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping({"/", ""})
    public String showNewsPage(Model model) {
        List<News> newsList = newsService.getAllNews();
        model.addAttribute("newsList", newsList);
        return "/admin-panel/pages/news/news";
    }

    @GetMapping("edit/{id}")
    public String showNewsEditPage(@PathVariable("id") Long newsId,
                                   Model model) {
        News news = newsService.getNewsById(newsId);
        model.addAttribute("news", news);
        return "/admin-panel/pages/news/news-page";
    }

    @PostMapping("update/{id}")
    public String updateNews(@PathVariable("id") Long newsId,
                             @ModelAttribute News news,
                             @RequestPart MultipartFile mainPicture,
                             @RequestPart(required = false) MultipartFile galleryPicture1,
                             @RequestPart(required = false) MultipartFile galleryPicture2,
                             @RequestPart(required = false) MultipartFile galleryPicture3,
                             @RequestPart(required = false) MultipartFile galleryPicture4,
                             @RequestPart(required = false) MultipartFile galleryPicture5) {
        newsService.updateNewsById(newsId, news,
                mainPicture, galleryPicture1,
                galleryPicture2, galleryPicture3,
                galleryPicture4, galleryPicture5);
        return "redirect:/admin/news/news-edit/" + newsId;
    }

    @GetMapping("add")
    public String addNewsPage(Model model) {
        model.addAttribute("news", new News());
        return "/admin-panel/pages/news/news-page";
    }
    @PostMapping("save")
    public String saveNews(@ModelAttribute News news,
                           @RequestPart MultipartFile mainPicture,
                           @RequestPart(required = false) MultipartFile galleryPicture1,
                           @RequestPart(required = false) MultipartFile galleryPicture2,
                           @RequestPart(required = false) MultipartFile galleryPicture3,
                           @RequestPart(required = false) MultipartFile galleryPicture4,
                           @RequestPart(required = false) MultipartFile galleryPicture5) {
        if (news.getId()==null){
            newsService.saveNews(news, mainPicture,
                    galleryPicture1, galleryPicture2,
                    galleryPicture3, galleryPicture4,
                    galleryPicture5);
        }else {
            newsService.updateNewsById(news.getId(), news, mainPicture,
                    galleryPicture1, galleryPicture2,
                    galleryPicture3, galleryPicture4,
                    galleryPicture5);
        }
        return "redirect:/admin/news";
    }

    @GetMapping("delete/{id}")
    public String deleteNewsPageById(@PathVariable("id") Long newsId) {
        newsService.deleteNewsById(newsId);
        return "redirect:/admin/news";
    }
}
