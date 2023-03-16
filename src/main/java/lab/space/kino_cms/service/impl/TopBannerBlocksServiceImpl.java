package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.TopBannerBlocks;
import lab.space.kino_cms.repository.TopBannerBlocksRepository;
import lab.space.kino_cms.service.TopBannerBlocksService;
import lab.space.kino_cms.service.TopBannerService;
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
public class TopBannerBlocksServiceImpl implements TopBannerBlocksService {
    private final TopBannerBlocksRepository topBannerBlocksRepository;
    private final TopBannerService topBannerService;

    @Override
    public List<TopBannerBlocks> getAllTopBannerBlocksByOrderByIdAsc() {
        log.info("---------------Get All TopBannerBlocks---------------");
        return topBannerBlocksRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public TopBannerBlocks getTopBannerBlockById(Long topBannerBlockId) {
        log.info("---------------Get TopBannerBlock By ID " + topBannerBlockId + "---------------");
        return topBannerBlocksRepository.findById(topBannerBlockId)
                .orElseThrow(() -> new EntityNotFoundException("TopBannerBlock Not Found"));
    }

    @Override
    public void updateTopBannerBlockPageById(Long topBannerBlockId, TopBannerBlocks requestedtopBannerBlocks,
                                             MultipartFile topBannerBlockImage) {
        log.info("---------------Update TopBannerBlock By ID " + topBannerBlockId + "---------------");
        TopBannerBlocks topBannerBlocks = getTopBannerBlockById(topBannerBlockId);

        topBannerBlocks.setUrl(requestedtopBannerBlocks.getUrl());
        topBannerBlocks.setText(requestedtopBannerBlocks.getText());

        if (FileUtil.saveFile(topBannerBlockImage.getOriginalFilename(), topBannerBlockImage)) {
            FileUtil.deleteFile(topBannerBlocks.getImage());
            topBannerBlocks.setImage(topBannerBlockImage.getOriginalFilename());
        }

        topBannerBlocksRepository.save(topBannerBlocks);
        log.info("---------------Success Update TopBannerBlock By ID " + topBannerBlockId + "---------------");
    }

    @Override
    public void saveTopBannerBlock(TopBannerBlocks topBannerBlocks, MultipartFile topBannerBlockImage) {
        log.info("---------------Save TopBannerBlock---------------");
        if (FileUtil.saveFile(topBannerBlockImage.getOriginalFilename(), topBannerBlockImage))
            topBannerBlocks.setImage(topBannerBlockImage.getOriginalFilename());

        topBannerBlocksRepository.save(topBannerBlocks);
        log.info("---------------Success Save TopBannerBlock---------------");
    }

    @Override
    public void addNewTopBannerBlock() {
        log.info("---------------Add TopBannerBlock---------------");
        TopBannerBlocks topBannerBlocks = new TopBannerBlocks();
        topBannerBlocks.setTopBanner(topBannerService.getTopBanner());
        topBannerBlocksRepository.save(topBannerBlocks);
        log.info("---------------Success Add TopBannerBlock---------------");
    }

    @Override
    public void deleteTopBannerBlockById(Long topBannerBlockId) {
        log.info("---------------Delete TopBannerBlock By ID " + topBannerBlockId + "---------------");
        TopBannerBlocks topBannerBlocks = getTopBannerBlockById(topBannerBlockId);
        if (topBannerBlocks.getImage() != null) {
            FileUtil.deleteFile(topBannerBlocks.getImage());
        }
        topBannerBlocksRepository.delete(topBannerBlocks);
        log.info("---------------Success Delete TopBannerBlock By ID " + topBannerBlockId + "---------------");
    }
}
