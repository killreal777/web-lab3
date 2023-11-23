package area.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class AreaDot implements Serializable {
    private float r;
    private float x;
    private float y;

    public AreaDot(float r, float x, float y) {
        setR(r);
        setX(x);
        setY(y);
    }

    public AreaDot() {
        // constructor without parameters
    }
}
