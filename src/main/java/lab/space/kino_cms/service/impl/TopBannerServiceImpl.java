package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.TopBanner;
import lab.space.kino_cms.model.TopBannerBlocks;
import lab.space.kino_cms.repository.TopBannerRepository;
import lab.space.kino_cms.service.TopBannerBlocksService;
import lab.space.kino_cms.service.TopBannerService;
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
public class TopBannerServiceImpl implements TopBannerService {
    private final TopBannerRepository topBannerRepository;
    private final TopBannerBlocksService topBannerBlocksService;


    @Override
    public TopBanner getTopBanner() {
        log.info("---------------Get TopBanner---------------");
        TopBanner topBanner = topBannerRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new EntityNotFoundException("TopBanner Not Found"));
        topBanner.getTopBannerBlocksList().sort(Comparator.comparingLong(TopBannerBlocks::getId));
        return topBanner;
    }

    @Override
    public void updateTopBanner(TopBanner requestedTopBanner) {
        log.info("---------------Update " + requestedTopBanner + "---------------");
        TopBanner topBanner = getTopBanner();
        List<TopBannerBlocks> requestedTopBannerBlocks = requestedTopBanner.getTopBannerBlocksList();
        topBanner.setDisabled(requestedTopBanner.isDisabled());
        topBanner.setRotatingSpeed(requestedTopBanner.getRotatingSpeed());
        topBanner.getTopBannerBlocksList().clear();
        for (TopBannerBlocks requestedTopBannerBlock : requestedTopBannerBlocks) {
            if (requestedTopBannerBlock.getId() != null) {
                TopBannerBlocks topBannerBlock = topBannerBlocksService.getTopBannerBlockById(requestedTopBannerBlock.getId());
                topBannerBlock.setUrl(requestedTopBannerBlock.getUrl());
                topBannerBlock.setText(requestedTopBannerBlock.getText());

                if (FileUtil.saveFile(requestedTopBannerBlock.getFile().getOriginalFilename(), requestedTopBannerBlock.getFile())) {
                    FileUtil.deleteFile(topBannerBlock.getImage());
                    topBannerBlock.setImage(requestedTopBannerBlock.getFile().getOriginalFilename());
                }
                topBanner.getTopBannerBlocksList().add(topBannerBlock);
            }else {
                if (FileUtil.saveFile(requestedTopBannerBlock.getFile().getOriginalFilename(), requestedTopBannerBlock.getFile())) {
                    requestedTopBannerBlock.setImage(requestedTopBannerBlock.getFile().getOriginalFilename());
                }
                topBanner.getTopBannerBlocksList().add(requestedTopBannerBlock);
            }
        }
        topBannerRepository.save(topBanner);
        log.info("---------------Success Update " + requestedTopBanner + "---------------");
    }
}
