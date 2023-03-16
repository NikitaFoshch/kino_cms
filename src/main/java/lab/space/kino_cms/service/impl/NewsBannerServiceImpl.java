package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.NewsBanner;
import lab.space.kino_cms.model.NewsBannerBlocks;
import lab.space.kino_cms.repository.NewsBannerRepository;
import lab.space.kino_cms.service.NewsBannerBlocksService;
import lab.space.kino_cms.service.NewsBannerService;
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
public class NewsBannerServiceImpl implements NewsBannerService {
    private final NewsBannerRepository newsBannerRepository;
    private final NewsBannerBlocksService newsBannerBlocksService;

    @Override
    public NewsBanner getNewsBanner() {
        log.info("---------------Get NewsBanner---------------");
        NewsBanner newsBanner = newsBannerRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new EntityNotFoundException("NewsBanner Not Found"));
        newsBanner.getNewsBannerBlocksList().sort(Comparator.comparingLong(NewsBannerBlocks::getId));
        return newsBanner;
    }

    @Override
    public void updateNewsBanner(NewsBanner requestednewsBanner) {
        log.info("---------------Update " + requestednewsBanner + "---------------");
        NewsBanner newsBanner = getNewsBanner();
        List<NewsBannerBlocks> requestedNewsBannerBlocks = requestednewsBanner.getNewsBannerBlocksList();
        newsBanner.setDisabled(requestednewsBanner.isDisabled());
        newsBanner.setRotatingSpeed(requestednewsBanner.getRotatingSpeed());
        newsBanner.getNewsBannerBlocksList().clear();
        for (NewsBannerBlocks requestedNewsBannerBlock : requestedNewsBannerBlocks) {
            if (requestedNewsBannerBlock.getId() != null) {
                NewsBannerBlocks newsBannerBlock = newsBannerBlocksService.getNewsBannerBlockById(requestedNewsBannerBlock.getId());
                newsBannerBlock.setUrl(requestedNewsBannerBlock.getUrl());

                if (FileUtil.saveFile(requestedNewsBannerBlock.getFile().getOriginalFilename(), requestedNewsBannerBlock.getFile())) {
                    FileUtil.deleteFile(newsBannerBlock.getImage());
                    newsBannerBlock.setImage(requestedNewsBannerBlock.getFile().getOriginalFilename());
                }
                newsBanner.getNewsBannerBlocksList().add(newsBannerBlock);
            }else {
                if (FileUtil.saveFile(requestedNewsBannerBlock.getFile().getOriginalFilename(), requestedNewsBannerBlock.getFile())) {
                    requestedNewsBannerBlock.setImage(requestedNewsBannerBlock.getFile().getOriginalFilename());
                }
                newsBanner.getNewsBannerBlocksList().add(requestedNewsBannerBlock);
            }
        }
        newsBannerRepository.save(newsBanner);
        log.info("---------------Success Update " + requestednewsBanner + "---------------");
    }
}
