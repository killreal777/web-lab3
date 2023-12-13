package area.app;

import area.data.HitCheckData;
import area.data.HitCheckServiceBean;
import area.data.AreaDotData;
import area.script.HitCheckScriptBean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

import jakarta.inject.Named;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ejb.EJB;
import jakarta.annotation.PostConstruct;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * CDI bean. For main page.
 * Provides: fields for area dot input, list for results output, methods for user actions.
 */

@Getter
@Setter
@NoArgsConstructor

@Named
@ApplicationScoped
public class MainPageBean implements Serializable {

    @EJB
    @Getter(value=AccessLevel.NONE)
    @Setter(value=AccessLevel.NONE)
    HitCheckServiceBean hitCheckService;

    @Inject
    @Getter(value=AccessLevel.NONE)
    @Setter(value=AccessLevel.NONE)
    HitCheckScriptBean hitCheckScript;

    private List<HitCheckData> resultsList;

    private float r;
    private float x;
    private float y;


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
}
