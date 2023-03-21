package lab.space.kino_cms.service;

import jakarta.mail.MessagingException;
import lab.space.kino_cms.model.EmailDistribution;

public interface EmailDistributionService {
    EmailDistribution getEmailDistribution();
    void updateEmailDistribution(EmailDistribution requstedEmailDistribution);
    void sendMessage() throws MessagingException;
}
