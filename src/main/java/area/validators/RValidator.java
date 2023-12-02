package area.validators;

import jakarta.faces.validator.FacesValidator;

@FacesValidator("rValidator")
public class RValidator extends FloatIntervalValidator {
    private static final float MIN = 2;
    private static final float MAX = 5;

    public RValidator() {
        super(MIN, MAX);
    }
}
