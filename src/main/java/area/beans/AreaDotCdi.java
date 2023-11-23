package area.beans;

import area.model.AreaDot;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ejb.EJB;

import java.io.Serializable;

@Getter
@Setter
@Named
@ApplicationScoped
public class AreaDotCdi implements Serializable {

    @EJB
    @Getter(value=AccessLevel.PRIVATE)
    @Setter(value=AccessLevel.PRIVATE)


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
