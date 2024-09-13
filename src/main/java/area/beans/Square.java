package area.beans;

import area.util.MBeanRegistryUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class Square implements SquareMBean {
    private float r;

    @PostConstruct
    public void init() {
        MBeanRegistryUtil.registerBean(this, "Square");
    }

    @PreDestroy
    public void destroy() {
        MBeanRegistryUtil.unregisterBean(this);
    }

    public void update(float r) {
        this.r = r;
    }

    @Override
    public double getSquare() {
        return rectangleSquare() + triangleSquare() + quarterCycleSquare();
    }

    private double rectangleSquare() {
        return r * r / 2d;
    }

    private double triangleSquare() {
        return r * r / 8d;
    }

    private double quarterCycleSquare() {
        return 3.14d * r * r / 4d;
    }
}
