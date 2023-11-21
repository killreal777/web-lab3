package area.script;

import area.exceptions.AreaDotValidationException;
import area.model.AreaDot;


class AreaDotValidator {
    protected void validate(AreaDot areaDot) {
        float r = areaDot.getR();
        float x = areaDot.getX();
        float y = areaDot.getY();

        validateR(r);
        validateX(x);
        validateY(y);
    }


    private void validateR(float r) {
        final int min = 2;
        final int max = 5;

        final boolean isRValid = r > min && r < max;

        if (!isRValid)
            throw new AreaDotValidationException();
    }


    private void validateX(float x) {
        final int min = -3;
        final int max = 5;

        boolean isXValid = x > min && x < max;

        if (!isXValid)
            throw new AreaDotValidationException();
    }


    private void validateY(float y) {
        // no validation for y
    }
}
