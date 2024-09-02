package area.data;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AreaDotData implements Serializable {
    private float r;
    private float x;
    private float y;

    public AreaDotData(float r, float x, float y) {
        this.r = r;
        this.x = x;
        this.y = y;
    }

    public AreaDotData() {
    }

    public float getR() {
        return this.r;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
