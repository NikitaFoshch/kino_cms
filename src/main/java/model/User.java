package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
@Data
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
    @Column(length = 50)
    private String language;
    @Column(length = 10)
    private String gender;
    @Column(length = 20)
    private String phone;
    private LocalDate birthday;
    @OneToOne
    private City city;
}
