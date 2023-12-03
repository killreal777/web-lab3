package area.validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

/**
 * Package-private abstract class for @FacesValidator child classes.
 * Validates float values by condition, defined in isValid abstract method.
 */
abstract class FloatValidator implements Validator<Object> {

    /**
     * Validation condition method.
     */
    protected abstract boolean isValid(float number);

    /**
     * Method for defining standard error message.
     */
    protected abstract String getStandardErrorMessage();


    /**
     * Parses float value from specified Object.
     * Validates float value by condition, defined in isValid abstract method.
     * In case of null, invalid value or incorrect number format throws jakarta.faces.validator.ValidatorException
     * with message, defined in getStandardErrorMessage abstract method.
     */
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        final float number = parseFloat(o);
        if (!isValid(number)) throw new ValidatorException(getStandardFacesErrorMessage());
    }

    /**
     * Parses float value from object.
     * In case of null or incorrect number format throws jakarta.faces.validator.ValidatorException.
     * Used for float validation.
     */
    private float parseFloat(Object o) throws ValidatorException {
        try {
            return Float.parseFloat(o.toString());
        } catch (NumberFormatException | NullPointerException e) {
            throw new ValidatorException(getStandardFacesErrorMessage());
        }
    }

    /**
     * Returns FacesMessage with standard error message.
     * Used for jakarta.faces.validator.ValidatorException creating.
     */
    private FacesMessage getStandardFacesErrorMessage() {
        return new FacesMessage(getStandardErrorMessage());
    }
}
