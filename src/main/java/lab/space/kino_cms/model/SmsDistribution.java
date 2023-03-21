package lab.space.kino_cms.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sms_distribution")
@Data
public class SmsDistribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int symbolCounter;
    private int pickUsersSend;
    @Column(length = 500)
    private String text;
}
