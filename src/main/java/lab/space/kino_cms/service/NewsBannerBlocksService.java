package lab.space.kino_cms.service;

import lab.space.kino_cms.model.NewsBannerBlocks;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NewsBannerBlocksService {
    List<NewsBannerBlocks> getAllNewsBannerBlocksByOrderByIdAsc();
    NewsBannerBlocks getNewsBannerBlockById(Long newsBannerBlockId);
    void updateNewsBannerBlockById(Long newsBannerBlockId, NewsBannerBlocks newsBannerBlocks,
                                      MultipartFile newsBannerBlockImage);
    void saveNewsBannerBlock(NewsBannerBlocks newsBannerBlocks, MultipartFile newsBannerBlockImage);
    void addNewNewsBannerBlock();
    void deleteNewsBannerBlockById(Long newsBannerBlockId);
}
