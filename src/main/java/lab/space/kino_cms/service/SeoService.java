package lab.space.kino_cms.service;

import lab.space.kino_cms.model.Seo;

public interface SeoService {
    Seo getSEOById(Long seoId);
    void updateSEOByID(Long seoId, Seo requestedSeo);
}
