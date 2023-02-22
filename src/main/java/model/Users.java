package model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Users extends MappedEntity {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String address;
    private String password;
    private String cardNumber;
    private String language;
    private String gender;
    private String phone;
    private Date birthday;
    @OneToOne
    @JoinColumn(name = "city_id")
    private City cityId;
}
