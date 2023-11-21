package area.beans;


import area.model.AreaDot;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;


@Named
@ApplicationScoped
public class AreaCheckCdi implements Serializable {

    @EJB
    private AreaCheckEjb areaCheckEjb;

    private Float r;
    private Float x;
    private Float y;


    public void executeAreaCheckScript() {
        validateNotNull();
        AreaDot areaDot = createAreaDot();
        areaCheckEjb.executeAreaCheckScript(areaDot);
    }

    private AreaDot createAreaDot() {
        AreaDot areaDot = new AreaDot();
        areaDot.setR(r);
        areaDot.setX(x);
        areaDot.setY(y);
        return areaDot;
    }

    private void validateNotNull() {

    }


    // getters and setters

    @NotNull
    public Float getR() {
        return r;
    }

    public void setR(Float r) {
        this.r = r;
    }


    @NotNull
    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }


    @NotNull
    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }
}
