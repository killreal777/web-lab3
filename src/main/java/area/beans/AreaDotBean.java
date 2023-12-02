package area.beans;

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

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Named
@ApplicationScoped
//TODO documentation (for input, warped Float for null check...)
public class AreaDotBean/*TODO better name*/ implements Serializable {
//TODO validator and convertor

    @EJB
    @Getter(value=AccessLevel.PRIVATE)
    @Setter(value=AccessLevel.PRIVATE)
    HitCheckServiceBean hitCheckService;

    @Inject
    @Getter(value=AccessLevel.PRIVATE)
    @Setter(value=AccessLevel.PRIVATE)
    HitCheckScriptBean hitCheckScript;

    private List<HitCheckData> resultsList;

    private Float r;
    private Float x;
    private Float y;


    /**
     * Executes hit check script
     */
    public void checkHit() {
        AreaDotData areaDotData = new AreaDotData(r, x, y);
        HitCheckData hitCheckData = hitCheckScript.executeHitCheckScript(areaDotData);
        hitCheckService.add(hitCheckData);
        updateResultsList();
    }

    public void cleanResults() {
        hitCheckService.clean();
        updateResultsList();
    }

    public void updateResultsList() {
        resultsList = hitCheckService.getAll();
    }

    private void validateNotNull() {

    }

}
