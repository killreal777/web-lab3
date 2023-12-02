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
     * Validates float values by condition, defined in isValid abstract method.
     * In case of null, invalid value or incorrect number format
     * throws jakarta.faces.validator.ValidationException
     * with message, defined in getStandardErrorMessage abstract method.
     */
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        final float number = parseFloat(o);
        if (!isValid(number)) throw new ValidatorException(getStandardFacesErrorMessage());
    }

    private float parseFloat(Object o) throws ValidatorException {
        try {
            if (o == null) throw new ValidatorException(getStandardFacesErrorMessage());
            return Float.parseFloat(o.toString());
        } catch (NumberFormatException e) {
            throw new ValidatorException(getStandardFacesErrorMessage());
        }
    }

    private FacesMessage getStandardFacesErrorMessage() {
        return new FacesMessage(getStandardErrorMessage());
    }
}
