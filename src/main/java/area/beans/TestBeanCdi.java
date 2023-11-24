package area.beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;

@Named
@ApplicationScoped
public class TestBeanCdi implements Serializable {
    private String message;



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
