package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.Seo;
import lab.space.kino_cms.repository.SeoRepository;
import lab.space.kino_cms.service.SeoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeoServiceImpl implements SeoService {
    private final SeoRepository seoRepository;

    @Override
    public Seo getSEOById(Long seoId) {
        log.info("---------------Get SEO ID " + seoId + "---------------");
        return seoRepository.findById(seoId)
                .orElseThrow(() -> new EntityNotFoundException("Seo Not Found By ID " + seoId));
    }

    @Override
    public void updateSEOByID(Long seoId, Seo requestedSeo) {
        log.info("---------------Update Seo ID " + seoId + "---------------");
        Seo seo = getSEOById(seoId);
        seo.setUrl(requestedSeo.getUrl());
        seo.setTitle(requestedSeo.getTitle());
        seo.setKeywords(requestedSeo.getKeywords());
        seo.setDescription(requestedSeo.getDescription());
        seoRepository.save(seo);
    }
}
