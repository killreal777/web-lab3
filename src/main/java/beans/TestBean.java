package beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;

@Named
@ApplicationScoped
public class TestBean implements Serializable {
    private String message = "Hello, JSF & CDI Bean!";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
