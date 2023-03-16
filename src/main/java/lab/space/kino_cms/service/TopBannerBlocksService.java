package lab.space.kino_cms.service;

import lab.space.kino_cms.model.TopBannerBlocks;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TopBannerBlocksService {
    List<TopBannerBlocks> getAllTopBannerBlocksByOrderByIdAsc();
    TopBannerBlocks getTopBannerBlockById(Long topBannerBlockId);
    void updateTopBannerBlockPageById(Long topBannerBlockId, TopBannerBlocks topBannerBlocks,
                                  MultipartFile topBannerBlockImage);
    void saveTopBannerBlock(TopBannerBlocks topBannerBlocks, MultipartFile topBannerBlockImage);
    void addNewTopBannerBlock();
    void deleteTopBannerBlockById(Long topBannerBlockId);
}
