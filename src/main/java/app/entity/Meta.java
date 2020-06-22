package app.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Meta {
    @Column(name = "dpi")
    private Short dpi;
}
