package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.SmsDistribution;
import lab.space.kino_cms.repository.SmsDistributionRepository;
import lab.space.kino_cms.service.SmsDistributionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmsDistributionServiceImpl implements SmsDistributionService {
    private final SmsDistributionRepository smsDistributionRepository;

    @Override
    public SmsDistribution getSmsDistribution() {
        log.info("---------------Get SmsDistribution---------------");
        return smsDistributionRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new EntityNotFoundException("SmsDistribution Not Found"));
    }

    @Override
    public void updateSmsDistribution(SmsDistribution requstedSmsDistribution) {
        log.info("---------------Update " + requstedSmsDistribution + "---------------");
        SmsDistribution smsDistribution = getSmsDistribution();
        smsDistribution.setPickUsersSend(requstedSmsDistribution.getPickUsersSend());
        smsDistribution.setText(requstedSmsDistribution.getText());
        smsDistributionRepository.save(smsDistribution);
        log.info("---------------Success Update " + requstedSmsDistribution + "---------------");
    }
}
