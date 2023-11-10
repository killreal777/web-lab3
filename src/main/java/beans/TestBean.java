package beans;

import jakarta.faces.bean.ApplicationScoped;
import jakarta.faces.bean.ManagedBean;

@ManagedBean(name = "testBean")
@ApplicationScoped
public class TestBean {
    private String name = "CDI test";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
