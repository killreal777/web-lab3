import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;

@Named
@ApplicationScoped
public class TestBeanCdi implements Serializable {

    @EJB
    private TestBeanEjb testBeanEjb;

    private String message;


    public void createTestEntity() {
        testBeanEjb.createTestEntity(message);
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
