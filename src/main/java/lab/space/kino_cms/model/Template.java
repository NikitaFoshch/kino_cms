package lab.space.kino_cms.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150)
    private String name;
}
