package area.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@Embeddable
public class HitCheck implements Serializable {
    private LocalTime startTime;
    private long executionTimeNano;
    private AreaDot areaDot;
    private boolean isHit;


    public HitCheck(LocalTime startTime, long executionTimeNano, AreaDot areaDot, boolean isHit) {
        setStartTime(startTime);
        setExecutionTimeNano(executionTimeNano);
        setAreaDot(areaDot);
        setHit(isHit);
    }

    public HitCheck() {
        // constructor without parameters
    }
}
