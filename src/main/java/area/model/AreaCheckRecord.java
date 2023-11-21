package area.model;

import java.io.Serializable;
import java.time.LocalTime;


public class AreaCheckRecord implements Serializable {
    private LocalTime startTime;
    private long executionTimeNano;
    private float r;
    private float x;
    private float y;
    private boolean isHit;


    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }


    public long getExecutionTimeNano() {
        return executionTimeNano;
    }

    public void setExecutionTimeNano(long executionTimeNano) {
        this.executionTimeNano = executionTimeNano;
    }


    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }


    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }


    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}
