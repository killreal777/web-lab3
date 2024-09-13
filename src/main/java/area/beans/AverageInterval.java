package area.beans;

import area.data.HitCheckData;
import area.util.MBeanRegistryUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.time.Duration;
import java.util.List;

@Named
@ApplicationScoped
public class AverageInterval implements AverageIntervalMBean {
    private List<HitCheckData> resultsList;

    @PostConstruct
    public void init() {
        MBeanRegistryUtil.registerBean(this, "AverageInterval");
    }

    @PreDestroy
    public void destroy() {
        MBeanRegistryUtil.unregisterBean(this);
    }

    public void update(List<HitCheckData> resultsList) {
        this.resultsList = resultsList;
    }

    @Override
    public long getAverageInterval() {
        if (resultsList == null || resultsList.size() < 2) {
            return 0;
        }

        long totalInterval = getTotalInterval();

        return totalInterval / (resultsList.size() - 1);
    }

    private long getTotalInterval() {
        long totalInterval = 0;

        for (int i = 1; i < resultsList.size(); i++) {
            HitCheckData previousHit = resultsList.get(i - 1);
            HitCheckData currentHit = resultsList.get(i);

            long interval = Duration.between(currentHit.getStartTime(), previousHit.getStartTime()).toMillis();
            System.out.println(interval);
            totalInterval += interval;
        }

        return totalInterval;
    }
}
