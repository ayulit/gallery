package app.entity;

import app.enums.UserType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Person extends EntityBase {

    //    @Column(name = "email", unique = true, nullable = false)
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_type")
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
