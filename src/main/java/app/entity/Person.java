package app.entity;

import app.enums.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Person extends EntityBase {
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_type")
    @Enumerated(value = EnumType.STRING)
    private UserType userType;
}
