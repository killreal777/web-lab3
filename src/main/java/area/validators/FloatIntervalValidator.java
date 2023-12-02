package area.validators;

/**
 * Package-private abstract class for @FacesValidator classes.
 * Validates if float number in (min; max) interval.
 * Interval boundaries are NOT included.
 */
abstract class FloatIntervalValidator extends FloatValidator {
    private final float min;
    private final float max;


    protected FloatIntervalValidator(float min, float max) {
        this.min = min;
        this.max = max;
    }


    /**
     * Validation condition method.
     */
    @Override
    protected boolean isValid(float number) {
        return (number > min && number < max);
    }

    /**
     * Method for defining standard error message.
     */
    @Override
    protected String getStandardErrorMessage() {
        return "(" + min + "; " + max + ")";
    }
}
