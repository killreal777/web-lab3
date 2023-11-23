package area.script;


import area.model.AreaDot;
import area.model.HitCheck;

import java.time.LocalTime;


public class HitCheckScript {
    private final AreaDotValidator areaDotValidator;
    private final HitChecker hitChecker;


    public HitCheckScript() {
        this.areaDotValidator = new AreaDotValidator();
        this.hitChecker = new HitChecker();
    }


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
