package lab.space.kino_cms.service.impl;


import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.NewsBannerBlocks;
import lab.space.kino_cms.repository.NewsBannerBlocksRepository;
import lab.space.kino_cms.service.NewsBannerBlocksService;
import lab.space.kino_cms.service.NewsBannerService;
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
public class NewsBannerBlocksServiceImpl implements NewsBannerBlocksService {
    private final NewsBannerBlocksRepository newsBannerBlocksRepository;
    private final NewsBannerService newsBannerService;

    @Override
    public List<NewsBannerBlocks> getAllNewsBannerBlocksByOrderByIdAsc() {
        log.info("---------------Get All NewsBannerBlocks---------------");
        return newsBannerBlocksRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public NewsBannerBlocks getNewsBannerBlockById(Long newsBannerBlockId) {
        log.info("---------------Get NewsBannerBlock By ID " + newsBannerBlockId + "---------------");
        return newsBannerBlocksRepository.findById(newsBannerBlockId)
                .orElseThrow(() -> new EntityNotFoundException("TopBannerBlock Not Found"));
    }

    @Override
    public void updateNewsBannerBlockById(Long newsBannerBlockId, NewsBannerBlocks requstedNewsBannerBlocks,
                                          MultipartFile newsBannerBlockImage) {
        log.info("---------------Update NewsBannerBlock By ID " + newsBannerBlockId + "---------------");
        NewsBannerBlocks newsBannerBlocks = getNewsBannerBlockById(newsBannerBlockId);

        newsBannerBlocks.setUrl(requstedNewsBannerBlocks.getUrl());

        if (FileUtil.saveFile(newsBannerBlockImage.getOriginalFilename(), newsBannerBlockImage)) {
            FileUtil.deleteFile(newsBannerBlocks.getImage());
            newsBannerBlocks.setImage(newsBannerBlockImage.getOriginalFilename());
        }

        newsBannerBlocksRepository.save(newsBannerBlocks);
        log.info("---------------Success Update NewsBannerBlock By ID " + newsBannerBlockId + "---------------");
    }

    @Override
    public void saveNewsBannerBlock(NewsBannerBlocks newsBannerBlocks, MultipartFile newsBannerBlockImage) {
        log.info("---------------Save NewsBannerBlock---------------");
        if (FileUtil.saveFile(newsBannerBlockImage.getOriginalFilename(), newsBannerBlockImage))
            newsBannerBlocks.setImage(newsBannerBlockImage.getOriginalFilename());

        newsBannerBlocksRepository.save(newsBannerBlocks);
        log.info("---------------Success Save NewsBannerBlock---------------");

    }


    @Override
    public void addNewNewsBannerBlock() {
        log.info("---------------Add NewsBannerBlock---------------");
        NewsBannerBlocks newsBannerBlocks = new NewsBannerBlocks();
        newsBannerBlocks.setNewsBanner(newsBannerService.getNewsBanner());
        newsBannerBlocksRepository.save(newsBannerBlocks);
        log.info("---------------Success Add NewsBannerBlock---------------");
    }

    @Override
    public void deleteNewsBannerBlockById(Long newsBannerBlockId) {
        log.info("---------------Delete NewsBannerBlock By ID " + newsBannerBlockId + "---------------");
        NewsBannerBlocks newsBannerBlocks = getNewsBannerBlockById(newsBannerBlockId);
        if (newsBannerBlocks.getImage() != null) {
            FileUtil.deleteFile(newsBannerBlocks.getImage());
        }
        newsBannerBlocksRepository.delete(newsBannerBlocks);
        log.info("---------------Success Delete NewsBannerBlock By ID " + newsBannerBlockId + "---------------");
    }
}
