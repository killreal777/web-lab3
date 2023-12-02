package area.validators;

import jakarta.faces.validator.FacesValidator;

@FacesValidator("xValidator")
public class XValidator extends FloatIntervalValidator {
    private static final float MIN = -3;
    private static final float MAX = 5;

    public XValidator() {
        super(MIN, MAX);
    }
}
