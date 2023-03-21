package lab.space.kino_cms.service.impl;

import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.EmailDistribution;
import lab.space.kino_cms.model.Template;
import lab.space.kino_cms.model.User;
import lab.space.kino_cms.repository.EmailDistributionRepository;
import lab.space.kino_cms.service.EmailDistributionService;
import lab.space.kino_cms.service.TemplateService;
import lab.space.kino_cms.service.UserService;
import lab.space.kino_cms.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
@Slf4j
public class EmailDistributionServiceImpl implements EmailDistributionService {
    private final JavaMailSender mailSender;
    private final EmailDistributionRepository emailDistributionRepository;
    private final UserService userService;
    private final TemplateService templateService;

    @Override
    public EmailDistribution getEmailDistribution() {
        log.info("---------------Get EmailDistribution---------------");
        return emailDistributionRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new EntityNotFoundException("EmailDistribution Not Found"));
    }

    @Override
    public void updateEmailDistribution(EmailDistribution requstedEmailDistribution) {
        log.info("---------------Update " + requstedEmailDistribution + "---------------");
        EmailDistribution emailDistribution = getEmailDistribution();
        if (requstedEmailDistribution.getTemplatesList().size() == 0) {
            emailDistribution.setPickUsersSend(requstedEmailDistribution.getPickUsersSend());
            emailDistribution.setPickTemplateSend(requstedEmailDistribution.getPickTemplateSend());
        } else {
            emailDistribution.setTemplatesList(requstedEmailDistribution.getTemplatesList());
            emailDistribution.setPickTemplateSend(emailDistribution.getTemplatesList().get(0).getId());
        }
        emailDistributionRepository.save(emailDistribution);
        log.info("---------------Success Update " + requstedEmailDistribution + "---------------");
    }

    @Override
    public void sendMessage() throws MessagingException {
        List<User> users = userService.getAllUsers();
        List<Template> templates = templateService.getAllTemplates();
        EmailDistribution emailDistribution = getEmailDistribution();
        String message = null;
        for (Template template : templates) {
            if (emailDistribution.getPickTemplateSend().equals(template.getId())) {
                message = template.getName();
                break;
            }
        }

        if (emailDistribution.getPickUsersSend() == 1) {
            for (User user : users) {
                if (!StringUtils.isEmpty(user.getEmail())) {

                    MimeMailMessage mimeMailMessage = new MimeMailMessage(mailSender.createMimeMessage());
                    MimeMessageHelper mailMessage = new MimeMessageHelper(mimeMailMessage.getMimeMessage(), true);

                    mailMessage.setTo(user.getEmail());
                    mailMessage.setSubject("Письмо");
                    mailMessage.setText("");
                    FileSystemResource file = new FileSystemResource(Objects.requireNonNull(FileUtil.getFile(message)));
                    mailMessage.addAttachment(Objects.requireNonNull(message), file);

                    mailSender.send(mimeMailMessage.getMimeMessage());
                }
            }
        } else {
            for (User user : users) {
                if (!StringUtils.isEmpty(user.getEmail()) && user.isMailSender()) {

                    MimeMailMessage mimeMailMessage = new MimeMailMessage(mailSender.createMimeMessage());
                    MimeMessageHelper mailMessage = new MimeMessageHelper(mimeMailMessage.getMimeMessage(), true);

                    mailMessage.setTo(user.getEmail());
                    mailMessage.setSubject("Письмо");
                    mailMessage.setText("");
                    mailMessage.addAttachment(Objects.requireNonNull(message),
                            Objects.requireNonNull(FileUtil.getFile(message)));

                    mailSender.send(mimeMailMessage.getMimeMessage());
                }
            }
        }

    }
}
