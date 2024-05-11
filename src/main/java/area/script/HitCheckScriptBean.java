package area.script;

import area.data.AreaDotData;
import area.data.HitCheckData;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.time.LocalTime;

/**
 * CDI bean implementing main business logic.
 * Represents script that checks if the dot hits the area, registers start time and execution time.
 */
@Named
@ApplicationScoped
public class HitCheckScriptBean {
    private final HitChecker hitChecker;

    public HitCheckScriptBean() {
        this.hitChecker = new HitChecker();
    }

    public HitCheckData execute(AreaDotData areaDotData) {
        long startTimeNano = System.nanoTime();
        LocalTime startTime = LocalTime.now();

        boolean isHit = hitChecker.isHit(areaDotData);

        long endTimeNano = System.nanoTime();
        long executionTimeNano = endTimeNano - startTimeNano;

        return new HitCheckData(startTime, executionTimeNano, areaDotData, isHit);
    }
}
