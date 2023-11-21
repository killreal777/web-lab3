package area.script;


import area.model.AreaDot;
import area.model.AreaCheckRecord;

import java.time.LocalTime;


public class AreaCheckScript {
    private final AreaDotValidator areaDotValidator;
    private final HitChecker hitChecker;


    public AreaCheckScript() {
        this.areaDotValidator = new AreaDotValidator();
        this.hitChecker = new HitChecker();
    }


    public AreaCheckRecord execute(AreaDot areaDot) {
        long startTimeNano = System.nanoTime();
        LocalTime startTime = LocalTime.now();

        validateAreaDot(areaDot);
        boolean isHit = hitChecker.isHit(areaDot);

        long endTimeNano = System.nanoTime();
        long executionTimeNano = startTimeNano - endTimeNano;

        return createRecord(startTime, executionTimeNano, areaDot, isHit);
    }

    private void validateAreaDot(AreaDot areaDot) {
        areaDotValidator.validate(areaDot);
    }

    private AreaCheckRecord createRecord(LocalTime startTime, long executionTime, AreaDot areaDot, boolean isHit) {
        AreaCheckRecord record = new AreaCheckRecord();
        record.setStartTime(startTime);
        record.setExecutionTimeNano(executionTime);
        record.setR(areaDot.getR());
        record.setX(areaDot.getX());
        record.setY(areaDot.getY());
        record.setHit(isHit);
        return record;
    }
}
