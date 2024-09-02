package area.data;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalTime;

@Embeddable
public class HitCheckData implements Serializable {
    private LocalTime startTime;
    private long executionTimeNano;
    private AreaDotData areaDotData;
    private boolean isHit;

    public HitCheckData(LocalTime startTime, long executionTimeNano, AreaDotData areaDotData, boolean isHit) {
        this.startTime = startTime;
        this.executionTimeNano = executionTimeNano;
        this.areaDotData = areaDotData;
        this.isHit = isHit;
    }

    public HitCheckData() {
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public long getExecutionTimeNano() {
        return this.executionTimeNano;
    }

    public AreaDotData getAreaDotData() {
        return this.areaDotData;
    }

    public boolean isHit() {
        return this.isHit;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setExecutionTimeNano(long executionTimeNano) {
        this.executionTimeNano = executionTimeNano;
    }

    public void setAreaDotData(AreaDotData areaDotData) {
        this.areaDotData = areaDotData;
    }

    public void setHit(boolean isHit) {
        this.isHit = isHit;
    }
}
