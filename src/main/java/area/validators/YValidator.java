package area.validators;

import jakarta.faces.validator.FacesValidator;

@FacesValidator("yValidator")
public class YValidator extends FloatIntervalValidator {
    private static final float MIN = -4;
    private static final float MAX = 4;

    public YValidator() {
        super(MIN, MAX);
    }

    @Override
    protected String getStandardErrorMessage() {
        return "Y: (-4; 4). ";
    }
}
