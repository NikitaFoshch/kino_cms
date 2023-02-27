package lab.space.kino_cms.service.impl;

import lab.space.kino_cms.model.Seo;
import lab.space.kino_cms.repository.SeoRepository;
import lab.space.kino_cms.service.SeoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeoServiceImpl implements SeoService {
    private final SeoRepository seoRepository;

    @Override
    public Seo getSEOById(Long seoId) {
        Optional<Seo> optionalSEO =seoRepository.findById(seoId);
        return optionalSEO.get();
    }

    @Override
    public void updateSEOByID(Long seoId, Seo requestedSeo) {
        Optional<Seo> optionalSEO = seoRepository.findById(seoId);
        Seo seo = optionalSEO.get();
        seo.setUrl(requestedSeo.getUrl());
        seo.setTitle(requestedSeo.getTitle());
        seo.setKeywords(requestedSeo.getKeywords());
        seo.setDescription(requestedSeo.getDescription());
        seoRepository.save(seo);
    }
}
