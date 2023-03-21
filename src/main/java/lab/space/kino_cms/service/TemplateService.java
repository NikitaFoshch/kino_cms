package lab.space.kino_cms.service;

import lab.space.kino_cms.model.Template;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TemplateService {
    List<Template> getAllTemplates();
    Template getTemplateById(Long templateId);
    void saveTemplate(MultipartFile htmlFile);

    void deleteTemplateById(Long templateId);
}
