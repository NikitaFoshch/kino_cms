package lab.space.kino_cms.service;

import lab.space.kino_cms.model.SmsDistribution;

public interface SmsDistributionService {
    SmsDistribution getSmsDistribution();
    void updateSmsDistribution(SmsDistribution requstedSmsDistribution);
}
