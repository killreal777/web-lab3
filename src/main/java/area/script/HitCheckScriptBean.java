package area.script;

import area.model.AreaDot;
import area.model.HitCheck;

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
     * Receives AreaDot instance.
     * Returns HitCheck instance.
     */
    public HitCheck execute(AreaDot areaDot) {
        long startTimeNano = System.nanoTime();
        LocalTime startTime = LocalTime.now();

        validateAreaDot(areaDot);
        boolean isHit = hitChecker.isHit(areaDot);

        long endTimeNano = System.nanoTime();
        long executionTimeNano = startTimeNano - endTimeNano;

        return new HitCheck(startTime, executionTimeNano, areaDot, isHit);
    }

    private void validateAreaDot(AreaDot areaDot) {
        areaDotValidator.validate(areaDot);
    }
}
