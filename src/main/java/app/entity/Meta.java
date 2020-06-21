package app.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Meta {
    @Column(name = "dpi")
    private Short dpi;

    public Short getDpi() {
        return dpi;
    }

    public void setDpi(Short dpi) {
        this.dpi = dpi;
    }
}
