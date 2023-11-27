package area.script;

import area.data.AreaDotData;
import area.data.HitCheckData;

import jakarta.inject.Named;

import java.time.LocalTime;

/**
 * CDI bean. Implements hit check logic.
 */
@Named
public class HitCheckScriptBean {
    private final AreaDotValidator areaDotValidator;
    private final HitChecker hitChecker;


    public HitCheckScriptBean() {
        this.areaDotValidator = new AreaDotValidator();
        this.hitChecker = new HitChecker();
    }


    /**
     * Executes hit check script.
     * Receives AreaDotData instance.
     * Returns HitCheckData instance.
     */
    public HitCheckData execute(AreaDotData areaDotData) {
        long startTimeNano = System.nanoTime();
        LocalTime startTime = LocalTime.now();

        validateAreaDot(areaDotData);
        boolean isHit = hitChecker.isHit(areaDotData);

        long endTimeNano = System.nanoTime();
        long executionTimeNano = startTimeNano - endTimeNano;

        return new HitCheckData(startTime, executionTimeNano, areaDotData, isHit);
    }

    private void validateAreaDot(AreaDotData areaDotData) {
        areaDotValidator.validate(areaDotData);
    }
}
