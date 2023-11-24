package area.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class HitCheck implements Serializable {
    private LocalTime startTime;
    private long executionTimeNano;
    private AreaDot areaDot;
    private boolean isHit;
}
