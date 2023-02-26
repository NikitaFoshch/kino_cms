package lab.space.kino_cms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends MappedEntity {
    @Column(length = 100)
    private String firstname;
    @Column(length = 100)
    private String lastname;
    @Column(length = 100)
    private String username;
    @Column(length = 100)
    private String email;
    @Column(length = 300)
    private String address;
    @Column(length = 100)
    private String password;
    @Column(length = 20)
    private String cardNumber;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Language language;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;
    @Column(length = 20)
    private String phone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD.MM.YYYY")
    private LocalDate birthday;
    @OneToOne
    private City city;

    @Getter
    @RequiredArgsConstructor
    public enum Gender{
        MALE("Мужской"),
        FEMALE("Женский");
        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Language{
        RU("Русский"),
        UA("Украинский");
        private final String value;
    }

}
