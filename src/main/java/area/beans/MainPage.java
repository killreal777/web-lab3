package area.beans;

import area.data.AreaDotData;
import area.data.HitCheckData;
import area.data.HitCheckServiceBean;
import area.script.HitCheckScriptBean;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * CDI bean. For main page.
 * Provides: fields for area dot input, list for results output, methods for user actions.
 */
@Named
@ApplicationScoped
public class MainPage implements Serializable {
    private HitCheckServiceBean hitCheckService;
    private HitCheckScriptBean hitCheckScript;

    private HitCount hitCount;
    private AverageInterval averageInterval;

    private List<HitCheckData> resultsList;

    private float r;
    private float x;
    private float y;

    @EJB
    public void setHitCheckService(HitCheckServiceBean hitCheckService) {
        this.hitCheckService = hitCheckService;
    }

    @Inject
    public void setHitCheckScript(HitCheckScriptBean hitCheckScript) {
        this.hitCheckScript = hitCheckScript;
    }

    @Inject
    public void setHitCount(HitCount hitCount) {
        this.hitCount = hitCount;
    }

    @Inject
    public void setAverageInterval(AverageInterval averageInterval) {
        this.averageInterval = averageInterval;
    }

    @PostConstruct
    public void init() {
        updateResultsList();
    }

    /**
     * Executes hit check script with inputted parameters.
     * Adds result to the database.
     * Updates resultsList.
     */
    public void checkHit() {
        AreaDotData areaDotData = new AreaDotData(r, x, y);
        HitCheckData hitCheckData = hitCheckScript.execute(areaDotData);
        hitCheckService.add(hitCheckData);
        updateResultsList();
    }

    /**
     * Deletes all results from database.
     * Cleans resultsList.
     */
    public void cleanResults() {
        hitCheckService.clean();
        updateResultsList();
    }

    /**
     * Updates resultsList with data from database.
     */
    public void updateResultsList() {
        resultsList = hitCheckService.getAll();
        Collections.reverse(resultsList);
        hitCount.update(resultsList);
        averageInterval.update(resultsList);
    }

    /**
     * X setter with negative zero fixing.
     */
    public void setX(float x) {
        this.x = fixNegativeZero(x);
    }

    /**
     * Y setter with negative zero fixing.
     */
    public void setY(float y) {
        this.y = fixNegativeZero(y);
    }

    /**
     * Negative zero fix method.
     */
    private float fixNegativeZero(float value) {
        return (value == 0) ? 0 : value;
    }

    public List<HitCheckData> getResultsList() {
        return this.resultsList;
    }

    public float getR() {
        return this.r;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setResultsList(List<HitCheckData> resultsList) {
        this.resultsList = resultsList;
    }

    public void setR(float r) {
        this.r = r;
    }
}
