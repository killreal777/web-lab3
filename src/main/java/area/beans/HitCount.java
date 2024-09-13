package area.beans;

import area.data.HitCheckData;
import area.util.MBeanRegistryUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.util.List;

@Named
@ApplicationScoped
public class HitCount extends NotificationBroadcasterSupport implements HitCountMBean {
    private List<HitCheckData> resultsList;
    private int sequenceNumber = 0;

    @PostConstruct
    public void init() {
        MBeanRegistryUtil.registerBean(this, "HitCount");
    }

    @PreDestroy
    public void destroy() {
        MBeanRegistryUtil.unregisterBean(this);
    }

    public void update(List<HitCheckData> resultsList) {
        this.resultsList = resultsList;

        if (resultsList.isEmpty()) return;

        var lastResult = resultsList.get(0);

        if (!lastResult.isHit()) {
            Notification notification = new Notification("Miss", this, sequenceNumber++);
            sendNotification(notification);
        }
    }

    @Override
    public long getTotalDots() {
        return resultsList.size();
    }

    @Override
    public long getHitDots() {
        return resultsList.stream().filter(HitCheckData::isHit).count();
    }
}
