package beans;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;

import java.io.Serializable;

@Named
@ViewScoped
public class TestBean implements Serializable {
    private String message = "Hello, JSF & CDI Bean!";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
