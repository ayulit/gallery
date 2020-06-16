package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Person extends EntityBase {

    @Column(name = "email")
    private String email;

    @Column(name = "user_name")
    private String userName;

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
}
