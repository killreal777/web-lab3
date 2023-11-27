package area.data;

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
public class HitCheckData implements Serializable {
    private LocalTime startTime;
    private long executionTimeNano;
    private AreaDotData areaDotData;
    private boolean isHit;
}
