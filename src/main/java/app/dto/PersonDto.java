package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PersonDto implements Serializable {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "username")
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
