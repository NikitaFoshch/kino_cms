package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.EmailDistribution;
import lab.space.kino_cms.model.Template;
import lab.space.kino_cms.repository.TemplateRepository;
import lab.space.kino_cms.service.EmailDistributionService;
import lab.space.kino_cms.service.TemplateService;
import lab.space.kino_cms.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateServiceImpl implements TemplateService {
    private final TemplateRepository templateRepository;
    private final EmailDistributionService emailDistributionService;

    public List<Template> getAllTemplates() {
        log.info("---------------Get All Templates---------------");
        return templateRepository.findAll();
    }

    @Override
    public Template getTemplateById(Long templateId) {
        log.info("---------------Get Template By ID " + templateId + "---------------");
        return templateRepository.findById(templateId)
                .orElseThrow(() -> new EntityNotFoundException("Template Not Found"));

    }

    @Override
    public void saveTemplate(MultipartFile htmlFile) {
        log.info("---------------Save Template---------------");
        EmailDistribution emailDistribution = emailDistributionService.getEmailDistribution();
        Template template = new Template();
        if (FileUtil.saveFile(htmlFile.getOriginalFilename(), htmlFile)) {
            template.setName(htmlFile.getOriginalFilename());
        }
        List<Template> templateList = emailDistribution.getTemplatesList();
        if (templateList.size()==5){
            templateList.remove(0);
            templateList.add(template);
        }else {
            templateList.add(template);
        }
        emailDistribution.setTemplatesList(templateList);
        emailDistributionService.updateEmailDistribution(emailDistribution);
        log.info("---------------Success Save Template---------------");
    }

    @Override
    public void deleteTemplateById(Long templateId) {
        log.info("---------------Delete Template By ID " + templateId + "---------------");
        Template template = getTemplateById(templateId);
        if (template.getName() != null) {
            FileUtil.deleteFile(template.getName());
        }

        templateRepository.deleteById(templateId);
        log.info("---------------Success Delete Template By ID " + templateId + "---------------");
    }
}
