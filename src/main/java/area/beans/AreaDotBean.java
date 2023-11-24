package area.beans;

import area.data.HitCheckServiceBean;
import area.model.AreaDot;
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
    HitCheckServiceBean hitCheckServiceBean;

    @Inject
    @Getter(value=AccessLevel.PRIVATE)
    @Setter(value=AccessLevel.PRIVATE)
    HitCheckScriptBean hitCheckScriptBean;

    private Float r;
    private Float x;
    private Float y;


    /**
     * Executes hit check script
     */
    public void executeHitCheckScript() {
        validateNotNull();
        AreaDot areaDot = new AreaDot(r, x, y);
    }


    private void validateNotNull() {

    }

}
