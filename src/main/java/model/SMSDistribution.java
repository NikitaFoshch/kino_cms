package model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sms_distribution")
@Data
public class SMSDistribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int counter;
}