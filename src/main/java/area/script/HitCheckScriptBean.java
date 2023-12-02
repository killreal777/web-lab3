package area.script;

import area.data.AreaDotData;
import area.data.HitCheckData;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.time.LocalTime;

/**
 * CDI bean. Represents hit check script.
 */
@Named
@ApplicationScoped
public class HitCheckScriptBean {
    private final HitChecker hitChecker;

    public HitCheckScriptBean() {
        this.hitChecker = new HitChecker();
    }

    /**
     * Executes hit check script.
     */
    public HitCheckData execute(AreaDotData areaDotData) {
        long startTimeNano = System.nanoTime();
        LocalTime startTime = LocalTime.now();

        boolean isHit = hitChecker.isHit(areaDotData);

        long endTimeNano = System.nanoTime();
        long executionTimeNano = endTimeNano - startTimeNano;

        return new HitCheckData(startTime, executionTimeNano, areaDotData, isHit);
    }
}
