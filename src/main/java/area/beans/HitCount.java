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
        noticeTreeMisses();
    }

    private void noticeTreeMisses() {
        if (resultsList.size() < 3) return;

        var res0 = resultsList.get(0);
        var res1 = resultsList.get(1);
        var res2 = resultsList.get(2);

        if (!res0.isHit() && !res1.isHit() && !res2.isHit()) {
            Notification notification = new Notification("3 misses", this, sequenceNumber++);
            sendNotification(notification);
        }
    }

    @Override
    public long getTotalDots() {
        return resultsList.size();
    }

    @Override
    public long getMissedDots() {
        return resultsList.size() - resultsList.stream().filter(HitCheckData::isHit).count();
    }
}
