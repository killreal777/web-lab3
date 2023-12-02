package area.data;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class HitCheckData implements Serializable {
    private LocalDateTime startTime;
    private long executionTimeNano;
    private AreaDotData areaDotData;
    private boolean isHit;
}
